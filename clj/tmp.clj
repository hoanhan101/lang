; functions
(defn hello-person[name]
  (str "hello " name))

(defn add-two[num1 num2]
  (print num1 "+" num2)
  (+ num1 num2))

(defn count-down-from[n]
  (loop [i n]
    (when (> i 0) (println i)
      (recur (- i 1)))))

(defn sum-up-to[n]
  (loop [sum 0 counter n]
    (if (= counter 0)
      sum
      (recur (+ sum counter) (- counter 1)))))

(defn factorial[n]
  (loop [product 1 counter n]
    (if (= counter 0)
      product
      (recur (* product counter) (- counter 1)))))

(defn less-than[nums delimiter]
  (doseq [n nums]
    (if (< n delimiter)
    (println n))))

; main
(println (hello-person "hoanh"))
(println " =" (add-two 1 2))

count-down-from 10
(println (sum-up-to 10))
(println (factorial 4))

(println (max 6 16 96 69 66))
(println (min 6 16 96 69 66))

(less-than [6 16 96 69 66] 36)
