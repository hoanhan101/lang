; check if two strings are anagram.

(ns clojure.test.anagram
  (:use clojure.test))

; count the number of occurrences of each character in a string.
(defn count-char[s]
  (frequencies (clojure.string/split s #"")))

; two strings are anagram if they have the same number of occurrences for their
; characters.
(defn is-anagram[s1 s2]
  (= (count-char s1) (count-char s2)))

(deftest anagram-tests
  (is (= true  (is-anagram "" "")))
  (is (= true  (is-anagram "a" "a")))
  (is (= false (is-anagram "a" "b")))
  (is (= true  (is-anagram "ab" "ba")))
  (is (= true  (is-anagram "abc" "acb")))
  (is (= true  (is-anagram "abc" "bac")))
  (is (= true  (is-anagram "abc" "bca")))
  (is (= true  (is-anagram "abc" "cab")))
  (is (= true  (is-anagram "abc" "cba")))
  (is (= false (is-anagram "abc" "cat"))))

(run-all-tests #"clojure.test.anagram")
