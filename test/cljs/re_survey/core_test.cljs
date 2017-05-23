(ns re-survey.core-test
  (:require [cljs.test :refer-macros [deftest testing is]]
            [re-survey.core :as core]))

(deftest fake-test
  (testing "fake description"
    (is (= 1 2))))
