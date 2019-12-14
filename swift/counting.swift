#!/usr/bin/swift

// countingSort implements counting sort algorithm for a given list of integers.
func countingSort(numbers: [Int], size: Int) -> [Int] {
    var counts = Array(repeating: 0, count: size+1)
    var out: [Int] = []

    for e in numbers {
        counts[e] += 1
    }

    for i in 0..<size {
        let count = counts[i]

        for _ in 0..<count {
            out.append(i)
        }
    }

    return out
}


func assertEqual(s1: [Int], s2: [Int]) {
    if s1 != s2 {
        print("'\(s1)' is not equal to '\(s2)'")
    } else {
        print("passed")
    }
}

struct test {
    let input1: [Int]
    let input2: Int
    let expected: [Int]
}

let tests: [test] = [
    test(input1: [], input2: 10, expected: []),
    test(input1: [6, 5, 4, 3, 2, 1], input2: 10, expected: [1, 2, 3, 4, 5, 6]),
    test(input1: [6, 5, 6, 4, 3, 2, 1], input2: 10, expected: [1, 2, 3, 4, 5, 6, 6]),
    test(input1: [6, 5, 6, 4, 3, 6, 2, 1], input2: 10, expected: [1, 2, 3, 4, 5, 6, 6, 6])
]

for t in tests {
    assertEqual(s1: t.expected, s2: countingSort(numbers: t.input1, size: t.input2))
}
