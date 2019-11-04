; greet a name

(ns clojure.test.personalized-hello
  (:use clojure.test))

(defn hello[name]
  (str "hello " name))

(deftest hello-tests
  (is (= "hello "  (hello "")))
  (is (= "hello  "  (hello " ")))
  (is (= "hello 101"  (hello 101)))
  (is (= "hello hoanh" (hello "hoanh")))
  (is (= "hello hoanh an" (hello "hoanh an"))))

(run-all-tests #"clojure.test.personalized-hello")
