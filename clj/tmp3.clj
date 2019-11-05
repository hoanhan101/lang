(ns clojure.test.tmp3
  (:use clojure.test))

(def sum #(reduce + %))
(def avg #(/ (sum %) (count %)))
(defn stats
  [numbers]
  (map #(% numbers) [sum count avg]))

(deftest stats-tests
  (is (= '(6 3 2) (stats [1 2 3])))
  (is (= '(60 3 20) (stats [10 20 30])))
  (is (= '(210 6 210/6) (stats [10 20 30 40 50 60]))))

(run-all-tests #"clojure.test.tmp3")
