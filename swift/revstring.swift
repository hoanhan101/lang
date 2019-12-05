#!/usr/bin/swift

// reverseString reverses a list of string in place.
func reverseString(input: [String]) -> [String] {
    var s = input
    var start = 0
    var end = s.count-1

    while start < end {
        let tmp = s[start]
        s[start] = s[end]
        s[end] = tmp

        start += 1
        end -= 1
    }

    return s
}

func assertEqual(s1: [String], s2: [String]) {
    if s1 != s2 {
        print(s1, "is not equal to", s2)
    } else {
        print("passed")
    }
}

struct test {
    var input: [String]
    var expected: [String]
}

var tests: [test] = [
    test(input: [], expected: []),
    test(input: ["h"], expected: ["h"]),
    test(input: ["h", "e"], expected: ["e", "h"]),
    test(input: ["h", "e", "l"], expected: ["l", "e", "h"]),
    test(input: ["h", "e", "l", "l", "o"], expected: ["o", "l", "l", "e", "h"])
]

for t in tests {
    assertEqual(s1: t.expected, s2: reverseString(input: t.input))
}
