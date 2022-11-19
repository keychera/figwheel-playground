(ns ^:figwheel-hooks chera.core 
  (:require
   [goog.dom :as gdom] 
   [reagent.dom :as rdom]))

(js/console.log "Chera says: Hello world!")

(defn hello-world []
  [:div
   [:h1 "This is chera"]
   [:h3 "and everything goes on..."]])

; below seems to be the heart of reagent, the edge of the software

(defn get-app-element []
  (gdom/getElement "app"))

(defn mount [el]
  (rdom/render [hello-world] el))

(defn mount-app-element []
  (when-let [el (get-app-element)]
    (mount el)))

(mount-app-element)

(defn ^:after-load on-reload []
  (mount-app-element) )