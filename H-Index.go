package main

import (
	"fmt"
	"sort"
)

type IntSliceDec []int

func (x IntSliceDec) Len() int           { return len(x) }
func (x IntSliceDec) Less(i, j int) bool { return x[i] > x[j] }
func (x IntSliceDec) Swap(i, j int)      { x[i], x[j] = x[j], x[i] }

/**
A scientist has an index h if h of their n papers have at least h citations each,
and the other n − h papers have no more than h citations each.
*/

func hIndex(citations []int) int {
	if len(citations) == 0 {
		return 0
	}
	sort.Sort(IntSliceDec(citations))

	// fmt.Println(citations)
	for i, c := range citations {
		// greedy algorithm
		// if a number < the count of numbers bigger than it (i.e. i+1),
		// then the rest numbers < i+1 and there will not be
		// \sum{c_i >= i+1} >= i+1
		if c < i+1 {
			return i
		}
	}
	// each number c statifies that c >= min(c) > max(i) = len(citations)
	return len(citations)
}

func main() {
	testCases := [][]int{
		{3, 0, 6, 1, 5},
		{1, 3, 1},
		{5},
		{11, 15},
		{4, 4, 0, 0},
	}
	for _, t := range testCases {
		fmt.Println(hIndex(t))
	}
}
