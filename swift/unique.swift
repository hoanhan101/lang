#!/usr/bin/swift

// given a list of integer where every element appears even number of time
// except for one, find that unique one in O(1) space.
func findUniqueID(numbers: [Int]) -> Int {
    var ones = 0

    for num in numbers {
        ones ^= num
    }

    return ones
}

func assertEqual(s1: Int, s2: Int) {
    if s1 != s2 {
        print("'\(s1)' is not equal to '\(s2)'")
    } else {
        print("passed")
    }
}

struct test {
    let input: [Int]
    let expected: Int
}

let tests: [test] = [
    test(input: [], expected: 0),
    test(input: [6], expected: 6),
    test(input: [10, 10], expected: 0),
    test(input: [6, 2, 2, 4, 4, 1, 1, 1, 1], expected: 6),
    test(input: [1, 1, 2, 4, 2, 1, 4, 6, 1], expected: 6),
    test(input: [4, 1, 2, 1, 6, 1, 4, 2, 1], expected: 6)
]

for t in tests {
    assertEqual(s1: t.expected, s2: findUniqueID(numbers: t.input))
}
