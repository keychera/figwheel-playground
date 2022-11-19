(ns ^:figwheel-hooks chera.core
  (:require
   [goog.dom :as gdom]
   [reagent.dom :as rdom]
   [reagent.core :as r]))

(js/console.log "Chera says: Hello world!")

; TODO improve hardcoded data, this is from IME
(def kazoeru {"匹" {"何" "なんびき"
                   "1" "いっぴき"
                   "2" "にひき"
                   "3" "さんびき"
                   "4" "よんひき"
                   "5" "ごひき"
                   "6" "ろっぴき"
                   "7" "ななひき"
                   "8" "はっぴき"
                   "9" "きゅうひき"
                   "10" "じゅうひき"}
              "個" {"何" "なんこ"
                   "1" "いっこ"
                   "2" "にこ"
                   "3" "さんこ"
                   "4" "よんこ"
                   "5" "ごこ"
                   "6" "ろっこ"
                   "7" "ななこ"
                   "8" "はっこ"
                   "9" "きゅうこ"
                   "10" "じゅうこ"}
              "日" {"何" "なんにち"
                   "1" "いちにち・ついたち"
                   "2" "ふつか"
                   "3" "みっか"
                   "4" "よっか"
                   "5" "いつか"
                   "6" "むいか"
                   "7" "なのか"
                   "8" "ようか"
                   "9" "ここのか"
                   "10" "じゅうにち"}
              "分" {"何" "なんぶん"
                   "1" "いっぷん"
                   "2" "にふん"
                   "3" "さんぷん"
                   "4" "よんぷん"
                   "5" "ごふん"
                   "6" "ろっぷん"
                   "7" "ななふん"
                   "8" "はっぷん"
                   "9" "きゅうふん"
                   "10" "じゅうふん"}
              "人" {"何" "なんにん"
                   "1" "ひとり"
                   "2" "ふたり"
                   "3" "さんにん"
                   "4" "よんにん"
                   "5" "ごにん"
                   "6" "ろくにん"
                   "7" "しちにん"
                   "8" "はちにん"
                   "9" "きゅうにん"
                   "10" "じゅうにん"}})

(defonce state (r/atom {:number "何" :counter (first (keys kazoeru))}))

(defn change-state [key val] (swap! state #(-> % (assoc key (-> val .-target .-value)))))

(def dropdown-number
  [:select {:id "number"
            :class "text-6xl mx-2"
            :on-change #(change-state :number %) } 
   [:option {:value "何"} "何"]
   (->> (range 1 11)
        (map (fn [idx] [:option {:value idx} idx])))])

(def dropdown-counter
  [:select {:id "counter"
            :class "text-6xl mx-2"
            :on-change #(change-state :counter %)} 
   (->> (keys kazoeru)
        (map (fn [counter] [:option {:value counter} counter])))])

; first example of https://tailwindcss.com/docs/utility-first
(defn kazoeru-tool []
  (let [{num :number  con :counter} @state]
   [:div {:class "kazoeru-div"}
   [:div {:class "kazoeru-comp"}
    [:div {:class "shrink-0"}
     [:img {:class "h-36 w-36 m-4" :src "./img/clojure.svg" :alt "chera"}]]
    [:div
     [:div {:class "text-8xl font-medium text-black my-2"} "数えましょう！"]
     [:p {:class "text-6xl text-slate-500"} "なんだったっけ？"]]] 
    [:div {:class "p-6 mx-16 my-16 bg-white rounded-xl shadow-lg flex items-center "}
     dropdown-number
     dropdown-counter
     [:div {:class "mx-auto"}
      [:p {:class "mx-12 text-6xl font-medium"}
      (str ((kazoeru con) num))]] 
      ] 
   ])
  ) 

(defn sidebar-icon 
  ([icon] (sidebar-icon icon "tooltip!"))
  ([icon text] [:div {:class "sidebar-icon group"} icon
           [:span {:class "sidebar-tooltip group-hover:scale-100"} text]]))

(defn sidebar []
  [:div {:class "sidebar"}
   (sidebar-icon "🗿" "-_-")
   (sidebar-icon "🛏️" "bobo")
   (sidebar-icon "λ" "lambda")
   ])

(defn headwind []
  [:div {:class "flex"}
   (sidebar)
   (kazoeru-tool)
   ])

; below seems to be the heart of reagent, the edge of the software

(defn get-app-element []
  (gdom/getElement "app"))

(defn mount [el]
  (rdom/render [headwind] el))

(defn mount-app-element []
  (when-let [el (get-app-element)]
    (mount el)))

(mount-app-element)

(defn ^:after-load on-reload []
  (mount-app-element))