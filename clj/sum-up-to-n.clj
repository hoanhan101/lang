; sum the numbers from 1 to n

(ns clojure.test.sum-up-to-n
  (:use clojure.test))

(defn sum-up-to[n]
  (loop [sum 0 counter n]
    (if (= counter 0)
      sum
      (recur (+ sum counter) (- counter 1)))))

(deftest sum-up-to-tests
  (is (= 0  (sum-up-to 0)))
  (is (= 1  (sum-up-to 1)))
  (is (= 3  (sum-up-to 2)))
  (is (= 6  (sum-up-to 3)))
  (is (= 10 (sum-up-to 4)))
  (is (= 15 (sum-up-to 5)))
  (is (= 21 (sum-up-to 6))))

(run-all-tests #"clojure.test.sum-up-to-n")
