#!/usr/bin/env bb

(require 
 '[clojure.main :refer [demunge]]
 '[babashka.fs :as fs]
 '[babashka.process :refer [shell]])

(defn fn-name [a-fn]
  (-> a-fn str demunge (str/split #"@") first (str/replace #"babashka." "")))

(defn does [act & args]
  (doall [(println (str "[bb] " (fn-name act) " " (reduce #(str %1 " " %2) args)))
          (apply act args)]))

(defn clean-build []
  (doall [(does fs/delete-tree "target/public")
          (does shell "clojure" "-M:fig:min")
          (does fs/delete-tree "target/public/cljs-out/dev")
          (does fs/copy-tree "resources/public" "target/public")
          (does fs/delete "target/public/css/.gitignore")
]))

;; error on push, "fatal: protocol '"https' is not supported" it said 
;; (defn publish-target []
;;   (doall [
;;           (does shell {:dir "target/public"} "git" "init")
;;           (does shell {:dir "target/public"} "git" "add" ".")
;;           (does shell {:dir "target/public"} "git" "commit" "-m" "\"Deploy to GitHub Pages\"")
;;           (does shell {:dir "target/public"} "git" "push" "--force" "\"https://github.com/keychera/figwheel-playground.git\"" "master:gh-pages") 
;;           ]))

(clean-build)
;; (publish-target)
(prn "done!")