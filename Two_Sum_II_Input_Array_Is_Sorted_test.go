package main

import (
	"fmt"
	"testing"
)

func TestTwoSum(t *testing.T) {
	type TestCase struct {
		numbers []int
		target  int
	}
	testCases := []TestCase{{[]int{2, 7, 11, 15}, 9},
		{[]int{2, 3, 4}, 6},
		{[]int{-1, 0}, -1},
		{[]int{5, 25, 75}, 100},
		{[]int{3, 24, 50, 79, 88, 150, 345}, 200}}
	for _, t := range testCases {
		fmt.Println(twoSum(t.numbers, t.target))
	}
}
