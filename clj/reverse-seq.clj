; reverse a sequence

(ns clojure.test.reverse-seq
  (:use clojure.test))

(defn reverse-seq [s]
  (reduce conj () s))

(deftest reverse-tests
  (is (= '()                     (reverse-seq [])))
  (is (= '(1)                    (reverse-seq [1])))
  (is (= '(1 2 4 6)              (reverse-seq [6 4 2 1])))
  (is (= '(1.0 2.0 4.0 6.0)      (reverse-seq [6.0 4.0 2.0 1.0])))
  (is (= '("one" "two" "three")  (reverse-seq ["three" "two" "one"])))
  (is (= '(true true false true) (reverse-seq [true false true true]))))

(run-all-tests #"clojure.test.reverse")
