#!/usr/bin/swift

/*
- Given a string, find the length of the longest substring in it with no more
  than k distinct characters.

Example:
- Input: string="araaci", k=1
  Output: 2
  Explanation: Longest substring with no more than 1 distinct characters is "aa".
- Input: string="araaci", k=2
  Output: 4
  Explanation: Longest substring with no more than 2 distinct characters is "araa".
- Input: string="araaci", k=3
  Output: 5
  Explanation: Longest substring with no more than 3 distinct characters is "araac".
*/

func longestSubstring(s: String, k: Int) -> Int {
    var maxLength: Int = 0
    var start: Int = 0

    // char keeps track of characters' frequencies.
    var char: [String: Int] = [:]

    for end in 0..<s.count {
        // insert characters until we have k distinct characters.
        let endChar = String(s[s.index(s.startIndex, offsetBy: end)])
        if char[endChar] == nil {
            char[endChar] = 0
        }
        char[endChar]! += 1

        // shrink the window until there is no more k distinct characters.
        while char.count > k {
            let startChar = String(s[s.index(s.startIndex, offsetBy: start)])

            // decrement the frequency of the one going out of the window and remove
            // it if its frequency becomes 0.
            char[startChar]! -= 1
            if char[startChar] == 0 {
                char.removeValue(forKey: startChar)
            }

            // increment the start index to move the window ahead by one element.
            start += 1
        }

        maxLength = max(maxLength, end-start+1)
    }

    return maxLength
}

func assertEqual(s1: Int, s2: Int) {
    if s1 != s2 {
        print("'\(s1)' is not equal to '\(s2)'")
    } else {
        print("passed")
    }
}

struct test {
    let input1: String
    let input2: Int
    let expected: Int
}

let tests: [test] = [
    test(input1: "", input2: 0, expected: 0),
    test(input1: "", input2: 1, expected: 0),
    test(input1: "a", input2: 0, expected: 0),
    test(input1: "a", input2: 1, expected: 1),
    test(input1: "aa", input2: 1, expected: 2),
    test(input1: "aa", input2: 2, expected: 2),
    test(input1: "ab", input2: 1, expected: 1),
    test(input1: "ab", input2: 2, expected: 2),
    test(input1: "araaci", input2: 1, expected: 2),
    test(input1: "araaci", input2: 2, expected: 4),
    test(input1: "araaci", input2: 3, expected: 5)
]

for t in tests {
    assertEqual(s1: t.expected, s2: longestSubstring(s: t.input1, k: t.input2))
}
