; tic tac toe game

(def mapa {
  :00 "_" :01 "_" :02 "_"
  :10 "_" :11 "_" :12 "_"
  :20 "_" :21 "_" :22 "_"
  }
)

(defn print-instruction[i j]
  (loop [x 0]
    (when (< x i)
      (loop [y 0]
        (when (< y j)
          (print (str x y) "")
          (recur (+ y 1))
        )
      )
      (println)
      (recur (+ x 1))
    )
  )
)

(defn print-board[i j]
  (loop [x 0]
    (when (< x i)
      (loop [y 0]
        (when (< y j)
          (print ((keyword (str x y)) mapa) "")
          (recur (+ y 1))
        )
      )
      (println)
      (recur (+ x 1))
    )
  )
)

(defn move[number sign]
  (def mapa (assoc mapa (keyword number) sign)
  )
)

(defn play[number sign]
  (move number sign)

  (println)
  (println ">> move" sign "to location" number)
  (print-board 3 3)
  (println)
)

(defn check3[l1 l2 l3]
  (if (and (not= "_" ((keyword l1) mapa)) (not= "_" ((keyword l2) mapa)) (not= "_" ((keyword l3) mapa)))
    (if (= ((keyword l1) mapa) ((keyword l2) mapa) ((keyword l3) mapa)) 
      true
      false
    )
    false
  )
)

(defn check-win[]
  (or
    (check3 "00" "01" "02")
    (check3 "10" "11" "12")
    (check3 "20" "21" "22")
    (check3 "00" "10" "20")
    (check3 "01" "11" "21")
    (check3 "02" "12" "22")
    (check3 "00" "11" "22")
    (check3 "02" "11" "20")
  )
)


(defn gameon[]
  (println ">> welcome to tic tac toe. here is our 3x3 board with its location:")
  (print-instruction 3 3)

  (println)

  (println ">> here is what our board looks like in the beginning when the game starts:")
  (print-board 3 3)

  (println)

  (loop [x 9]
    (when (> x 0)
      (println x "enter the location (00 to 22) first, then enter the sign (X or O) in a new line")
      (let [a (read-line) b (read-line)]
        (play a b)
        (if (= true (check-win))
          ; FIXME - can't "break" a loop in clojure. need to find a better way
          ; to do this.
          (println "*** WE HAVE FOUND A WINNER. HIT CTRL-C TO QUIT ***")
        )
      )
      (recur (- x 1))
    )
  )
)

(gameon)
