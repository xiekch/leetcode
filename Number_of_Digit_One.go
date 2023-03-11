package main

import "fmt"

func countDigitOne(n int) int {
	m := make(map[int]int)
	// defer fmt.Println(m)
	return countDigitOneInner(n, m)
}

func countDigitOneInner(n int, m map[int]int) int {
	if res, ok := m[n]; ok {
		return res
	}
	if n == 0 {
		return 0
	}
	if n < 10 {
		return 1
	}
	res := 0
	highestDigit, highestCount := calHighestDigit(n)
	// println(n, highestDigit, highestCount)
	if highestDigit > 1 {
		res = countDigitOneInner(n%highestCount, m) +
			highestDigit*countDigitOneInner(highestCount-1, m) +
			highestCount
	} else {
		res = countDigitOneInner(n%highestCount, m) +
			n%highestCount + 1 +
			countDigitOneInner(highestCount-1, m)
	}
	m[n] = res
	return res
}

func calHighestDigit(n int) (highestDigit int, highestCount int) {
	highestDigit = 0
	highestCount = 1
	for n != 0 {
		highestDigit = n
		n /= 10
		highestCount *= 10
	}

	highestCount /= 10
	return
}

func main() {
	testCases := []int{13, 0, 99, 333, 24343414}
	for _, testCase := range testCases {
		fmt.Println(testCase, ":", countDigitOne(testCase))
		println()
	}
}
