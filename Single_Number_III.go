package main

// https://leetcode.com/problems/single-number-iii/solutions/68900/accepted-c-java-o-n-time-o-1-space-easy-solution-with-detail-explanations/

import "fmt"

func singleNumber(nums []int) []int {
	diff := 0
	for _, n := range nums {
		diff ^= n
	}

	// the rightmost set bit of diff
	diff &= -diff
	println(diff)
	a, b := 0, 0
	for _, n := range nums {
		if n&diff == 0 {
			a ^= n
		} else {
			b ^= n
		}
	}
	return []int{a, b}
}

func main() {
	testCases := [][]int{{0, 0, 1, 3}}
	for _, testestCase := range testCases {
		fmt.Println(singleNumber((testestCase)))
	}
}
