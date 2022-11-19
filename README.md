# figwheel playground

quick start

    clojure -A:fig:build

production

    rm -rf target/public
    clojure -A:fig:min

### learning resources used

- https://clojurescript.org/guides/quick-start
- https://figwheel.org/docs/installation.html
- https://dawranliou.com/blog/vanilla-cljs/
- https://github.com/kuzmisin/closurecheatsheet/blob/master/dom.md
- https://google.github.io/closure-library/api/goog.dom.html
### structure learnt from 
this project is not generated, mainly just copy paste things that I need from the generated project

    clj -Tclj-new create :template figwheel-main :name chera/hello :args '["--reagent"]'


### tailwind cli

tailwind cli downloaded, put to path, renamed as `tailwind`

    tailwind -i ./src/input.css -o ./resources/public/css/style.css --watch

resources used for tailwinds

- https://tailwindcss.com/docs/installation
- Fireship Tailwind tutorial - https://youtu.be/pfaSUYaSgRo