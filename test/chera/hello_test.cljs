(ns chera.hello-test
  (:require [chera.num-converter :refer [west-arabic->japanese]]
            [cljs.test :refer-macros [deftest are]]))

(deftest test-conversion
  (are [num expected] (= (west-arabic->japanese num) expected)
    1 "いち"
    10 "じゅう"
    100 "ひゃく1"
    1000 "せん"))