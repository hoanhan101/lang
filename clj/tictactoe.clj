; tic tac toe game

; board represents a tic tac toe board. it maps a location (from 00 to 22) to a
; symbol (X or O). initialize symbols as underscore when the game starts.
(def board {
  :00 "_" :01 "_" :02 "_"
  :10 "_" :11 "_" :12 "_"
  :20 "_" :21 "_" :22 "_"
  }
)

; print-locations the board with its locations.
(defn print-locations[i j]
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

; print-board prints the current board.
(defn print-board[i j]
  (loop [x 0]
    (when (< x i)
      (loop [y 0]
        (when (< y j)
          (print ((keyword (str x y)) board) "")
          (recur (+ y 1))
        )
      )
      (println)
      (recur (+ x 1))
    )
  )
)

; move updates a symbol in a board's location.
(defn move[location sym]
  (def board (assoc board (keyword location) sym)
  )
)

; plays updates a symbol in a board's location and prints out the
; updated/current board.
(defn play[location sym]
  (move location sym)

  (println)
  (println ">> move" sym "to location" location)
  (print-board 3 3)
  (println)
)

; check3 checks if 3 symbols from the 3 given locations are not undersocre and
; the same.
(defn check3[l1 l2 l3]
  (if (and (not= "_" ((keyword l1) board)) (not= "_" ((keyword l2) board)) (not= "_" ((keyword l3) board)))
    (if (= ((keyword l1) board) ((keyword l2) board) ((keyword l3) board)) 
      true
      false
    )
    false
  )
)

; check-win checks if there exists a win state in the board. a win state is a
; state where 3 symbols on a straight line are the same. there are only 8 win
; states in a 3x3 board as below.
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

; gameon is the main function to run the game.
(defn gameon[]
  (println ">> welcome to tic tac toe. here is our 3x3 board with its location:")
  (print-locations 3 3)

  (println)

  (println ">> here is what our board looks like in the beginning when the game starts:")
  (print-board 3 3)

  (println)

  (loop [x 9]
    (when (> x 0)
      (println x "enter a location (00 to 22) first, then enter a symbol (X or O) in a new line")
      (let [a (read-line) b (read-line)]
        (play a b)
        (if (= true (check-win))
          (println "*** WE HAVE FOUND A WINNER.***")
          (recur (- x 1))
        )
      )
    )
  )
)

(gameon)
