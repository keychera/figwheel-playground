# figwheel playground

quick start

    clojure -A:fig:build

production

    clojure -A:fig:min

To clean all compiled files:

    rm -rf target/public

### learning resources used

- https://clojurescript.org/guides/quick-start
- https://figwheel.org/docs/installation.html
- https://dawranliou.com/blog/vanilla-cljs/
- https://github.com/kuzmisin/closurecheatsheet/blob/master/dom.md
- https://google.github.io/closure-library/api/goog.dom.html
- https://tailwindcss.com/docs/installation/play-cdn

### structure learnt from 
this project is not generated, mainly just copy paste things that I need from the generated project

    clj -Tclj-new create :template figwheel-main :name chera/hello :args '["--reagent"]'