#!/usr/bin/swift

// shuffle a list of integers in-place.
func shuffle(numbers: inout [Int]) -> [Int] {
    if numbers.count <= 1 {
        return numbers
    }

    let lastIndex = numbers.count - 1
    for i in 0..<numbers.count {
        let randomIndex = Int.random(in: i...lastIndex)

        if i != randomIndex {
            let tmp = numbers[i]
            numbers[i] = numbers[randomIndex]
            numbers[randomIndex] = tmp
        }
    }

    return numbers
}

var t = [1, 2, 3, 4, 5, 6]
print(shuffle(numbers: &t))
print(shuffle(numbers: &t))
print(shuffle(numbers: &t))
print(shuffle(numbers: &t))
print(shuffle(numbers: &t))
print(shuffle(numbers: &t))
