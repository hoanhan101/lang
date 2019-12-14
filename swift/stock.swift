#!/usr/bin/swift

// given a list of stock prices in chronological order, getMaxProfit returns
// the max profit from buying at earlier time and selling at later time.
func getMaxProfit(stocks: [Int]) -> Int {
    if stocks.count < 2 {
        return 0
    }

    var minPrice = stocks[0]
    var maxProfit = stocks[1] - stocks[0]

    for currentPrice in stocks {
        let potentialProfit = currentPrice - minPrice
        maxProfit = max(potentialProfit, maxProfit)
        minPrice = min(minPrice, currentPrice)
    }

    return maxProfit
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
    test(input: [10], expected: 0),
    test(input: [10, 10], expected: 0),
    test(input: [10, 7, 5, 8, 11, 9], expected: 6),
    test(input: [10, 2, 5, 4, 7, 1], expected: 5),
    test(input: [10, 7, 2, 1], expected: 0)
]

for t in tests {
    assertEqual(s1: t.expected, s2: getMaxProfit(stocks: t.input))
}
