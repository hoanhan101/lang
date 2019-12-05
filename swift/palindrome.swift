#!/usr/bin/swift

// isPalindrome checks if a given string's permutation is a palindrome.
func isPalindrome(input: String) -> Bool {
    var m: [String: Int] = [:]

    for c in input {
        let key = m[String(c)] != nil
        if key {
            m[String(c)] = nil
        } else {
            m[String(c)] = 1
        }
    }

    if m.count > 1 {
        return false
    }

    return true
}

func assertEqual(s1: Bool, s2: Bool) {
    if s1 != s2 {
        print("'\(s1)' is not equal to '\(s2)'")
    } else {
        print("passed")
    }
}

struct test {
    let input: String
    let expected: Bool
}

let tests: [test] = [
    test(input: "", expected: true),
    test(input: "l", expected: true),
    test(input: "lo", expected: false),
    test(input: "ol", expected: false),
    test(input: "lol", expected: true),
    test(input: "llo", expected: true),
    test(input: "oll", expected: true)
]

for t in tests {
    assertEqual(s1: t.expected, s2: isPalindrome(input: t.input))
}
