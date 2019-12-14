#!/usr/bin/swift

// mergeSortedArray merges 2 sorted array and returns a new one.
func mergeSortedArray(a1: [Int], a2: [Int]) -> [Int] {
	var out: [Int] = []
	var i: Int = 0
	var j: Int = 0

	while i < a1.count && j < a2.count {
		if a1[i] < a2[j] {
			out.append(a1[i])
			i += 1
		} else {
			out.append(a2[j])
			j += 1
		}
	}

	if i < a1.count {
		out += a1[i...]
	}

	if j < a2.count {
		out += a2[j...]
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
    let input2: [Int]
    let expected: [Int]
}

let tests: [test] = [
    test(input1: [], input2: [], expected: []),
    test(input1: [1], input2: [1], expected: [1, 1]),
    test(input1: [1], input2: [2], expected: [1, 2]),
    test(input1: [1, 3, 5], input2: [2, 4, 6], expected: [1, 2, 3, 4, 5, 6]),
    test(input1: [1, 3, 5, 16, 66], input2: [2, 4, 6, 166], expected: [1, 2, 3, 4, 5, 6, 16, 66, 166])
]

for t in tests {
    assertEqual(s1: t.expected, s2: mergeSortedArray(a1: t.input1, a2: t.input2))
}
