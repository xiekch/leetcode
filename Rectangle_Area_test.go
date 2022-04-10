package main

import (
	"testing"
)

func TestComputeArea(t *testing.T) {
	testCases := [][]int{[]int{-2, -2, 2, 2, 3, 3, 4, 4}}
	for _, testCase := range testCases {
		t.Log(computeArea(testCase[0], testCase[1], testCase[2], testCase[3],
			testCase[4], testCase[5], testCase[6], testCase[7]))
	}
}
