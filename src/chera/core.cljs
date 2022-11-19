(ns ^:figwheel-hooks chera.core 
  (:require
   [goog.dom :as gdom] 
   [reagent.dom :as rdom]))

(js/console.log "Chera says: Hello world!")

; first example of https://tailwindcss.com/docs/utility-first
(defn tailwind []
  [:div {:class "p-6 max-w-sm mx-auto bg-white rounded-xl shadow-lg flex items-center space-x-4"}
   [:div {:class "shrink-0"}
    [:img {:class "h-12 w-12" :src "/img/clojure.svg" :alt "chera"}]
    ]
   [:div
    [:div {:class "text-xl font-medium text-black"} "Chera is here"]
    [:p {:class "text-slate-500"} "and everything goes on..."]
    ]])

; below seems to be the heart of reagent, the edge of the software

(defn get-app-element []
  (gdom/getElement "app"))

(defn mount [el]
  (rdom/render [tailwind] el))

(defn mount-app-element []
  (when-let [el (get-app-element)]
    (mount el)))

(mount-app-element)

(defn ^:after-load on-reload []
  (mount-app-element) )