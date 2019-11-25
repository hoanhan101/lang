#!/usr/bin/swift

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

print(reverseString(input: ["h", "e", "l", "l", "o"]))
