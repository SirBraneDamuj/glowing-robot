(ns indexing.cards-test
  (:require [clojure.test :refer :all]
            [indexing.cards :refer :all]))

(deftest test-route
  (testing "Route creates the url correctly"
    (is (= (route "/sets") "http://netrunnercards.info/api/sets"))))

(def testing-set
  {:set "Core Set"
   :guid "975fe9ee-7c7c-4d05-bd35-d159f92a1294"
   :search "e:core"})

(deftest test-set-list
  (testing "Retrieves the correct set list"
    (let [card (first (set-list testing-set))]
      (is (= (:setname card) "Core Set"))
      (is (= (:title card) "Noise: Hacker Extraordinaire")))))
