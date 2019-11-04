; calculate the factorial of a given number

(ns clojure.test.factorial
  (:use clojure.test))

(defn factorial[n]
  (loop [product 1 counter n]
    (if (= counter 0)
      product
      (recur (* product counter) (- counter 1)))))

(deftest factorial-tests
  (is (= 1   (factorial 0)))
  (is (= 1   (factorial 1)))
  (is (= 2   (factorial 2)))
  (is (= 6   (factorial 3)))
  (is (= 24  (factorial 4)))
  (is (= 120 (factorial 5)))
  (is (= 720 (factorial 6))))

(run-all-tests #"clojure.test.factorial")
