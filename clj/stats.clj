; return stats (sum, average, max) of a sequence

(ns clojure.test.stats
  (:use clojure.test))

(def sum #(reduce + %))

(def avg #(/ (sum %) (count %)))

(def amax #(apply max %))

(defn stats
  [numbers]
  (map #(% numbers) [sum avg amax]))

(deftest stats-tests
  (is (= '(16 8 10)    (stats [6 10])))
  (is (= '(160 80 100) (stats [60 100])))
  (is (= '(300 60 100) (stats [60 100 40 50 50]))))

(run-all-tests #"clojure.test.stats")
