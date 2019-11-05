; (def a-hashmap (hash-map :a 1 :b 2 :c 3))
; (println a-hashmap)

; (def another-hashmap {:a 1, :b 2, :c 3})
; (println another-hashmap)

; (println (:a another-hashmap))
; (println (:d another-hashmap))

(println (apply hash-map [:a 1 :b 2 :c 3]))

; (def outdated-hashmap {:a 1, :b 2, :c 3})
; (def newer-hashmap (assoc outdated-hashmap :d 4))
; (def newest-hashmap (assoc newer-hashmap :a 22))
; (println outdated-hashmap)
; (println newer-hashmap)
; (println newest-hashmap)

; (println (frequencies (clojure.string/split "abca" #"")))
; (println (frequencies ["a", "b", "c", "a"]))
; (println (frequencies (clojure.string/split "a b c a" #"\s")))



; (println (clojure.string/split "abca" #""))

; (ns clojure.test.tmp
;   (:use clojure.test))

; (deftest tmp-tests
;   (is (= {a 2, b 1, c 1} (frequencies ["a", "b", "c", "a"])))
;   (is (= (frequencies ["a", "b", "c", "a"]) (frequencies (clojure.string/split "abca" #"")))))

; (run-all-tests #"clojure.test.tmp")
