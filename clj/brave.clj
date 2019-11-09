(ns clojure.test.tmp4
  (:use clojure.test))

; define an anonymous func that sums all the numbers in the arguments
(def sum #(reduce + %))

(def avg #(/ (sum %) (count %)))

(def add10 (partial + 10))

(defn stats
  [numbers]
  (map #(% numbers) [sum count avg]))

(deftest tmp-tests
  (is (= 16 (add10 6)))
  (is (= '(0 2 4 6 8) (filter even? (range 10))))
  (is (= 2 (apply max [0 1 2]))) ; instead of (max [0 1 2])
  (is (= 2 (max 0 1 2)))
  (is (= '(4 5 6 7 8 9 10) (drop 3 [1 2 3 4 5 6 7 8 9 10])))
  (is (= '(1 2 3) (take 3 [1 2 3 4 5 6 7 8 9 10])))
  (is (= '(6 3 2) (stats [1 2 3])))
  (is (= 2 (avg [1 2 3])))
  (is (= 6 (sum [1 2 3])))
  (is (= '(2 3 4) (map inc [1 2 3])))
  (is (= '("aA" "bB" "cC") (map str ["a" "b" "c"] ["A" "B" "C"])))
  (is (= "" ""))
  (is (= true true)))

(run-all-tests #"clojure.test.tmp4")
