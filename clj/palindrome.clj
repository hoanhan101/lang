; check if a string is a palindrome

(ns clojure.test.palindrome
  (:use clojure.test))

(defn is-palindrome[s]
  (= s (apply str (reverse s))))

(deftest palindrome-tests
  (is (= true  (is-palindrome "")))
  (is (= true  (is-palindrome "a")))
  (is (= true  (is-palindrome "aa")))
  (is (= false (is-palindrome "ax")))
  (is (= true  (is-palindrome "aaa")))
  (is (= true  (is-palindrome "axa")))
  (is (= false (is-palindrome "aax")))
  (is (= false (is-palindrome "xaa"))))

(run-all-tests #"clojure.test.palindrome")
