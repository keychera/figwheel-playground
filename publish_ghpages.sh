#!/bin/bash
# https://stackoverflow.com/a/37685922/8812880
# https://gist.github.com/ramnathv/2227408

rm -rf target/public
clojure -A:fig:min
mkdir resources/public/cljs-out
cp target/public/cljs-out/dev-main.js resources/public/cljs-out

# do manually, TODO automate this flow
# cd resources/public
# git init
# git add .
# git commit -m "Deploy to GitHub Pages"
# git push --force "https://github.com/keychera/figwheel-playground.git" master:gh-pages
