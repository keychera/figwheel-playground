(ns chera.core 
  (:require [goog.dom :as gom]))

(js/console.log "Chera says: there world!")

(def adiv (gom/createDom "div" {:class "hey"} "chera is here"))

(as-> (gom/getElement "app") it
    (gom/append it adiv)
    )