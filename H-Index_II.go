package main

import (
	"fmt"
	"sort"
)

/**
A scientist has an index h if h of their n papers have at least h citations each,
and the other n − h papers have no more than h citations each.
*/

func hIndex(citations []int) int {
	if len(citations) == 0 {
		return 0
	}
	// fmt.Println(citations)
	low, high := 0, len(citations)
	length := len(citations)
	for low < high {
		mid := (low + high) / 2
		if length-mid > citations[mid] {
			low = mid + 1
		} else {
			high = mid
		}
	}
	return length - low
}

func main() {
	testCases := [][]int{
		{3, 0, 6, 1, 5},
		{1, 3, 1},
		{5},
		{11, 15},
		{4, 4, 0, 0},
		{4, 3, 0},
		{2, 3},
		{0},
	}
	for _, t := range testCases {
		sort.Sort(sort.IntSlice(t))
		fmt.Println(hIndex(t))
	}
}
