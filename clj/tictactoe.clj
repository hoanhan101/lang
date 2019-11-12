; tic tac toe game
(def mapa {})

(defn printBoard [i j] (loop [x 0]
    (when (< x i)
      (loop [y 0]
        (when (< y j)
        (print ((keyword (str x y)) mapa) "")
          ; (print (aget coll x y))
      (recur (+ y 1))))
      (println)
  (recur (+ x 1)))))

(defn move[number sign]
  (def mapa (assoc mapa (keyword number) sign)))

(defn play[number sign]
  (move number sign)
  (printBoard 3 3)
  (println)
  )

(defn gameon[]
  (loop [x 9]
    (when (> x 0) ; when this is true
          (println x "enter the location first, then enter the sign in a new line")
          (let [a (read-line) b (read-line)]
            (play a b)
          )
        (recur (- x 1)) ; otherwise add it
    )
  )
)

(gameon)
