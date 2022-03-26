package main

import (
	"testing"
)

type testCase struct {
	gas, cost []int
}

func TestCanCompleteCircuit(t *testing.T) {
	testCases := []testCase{{[]int{2, 3, 4}, []int{2, 4, 3}},
		{[]int{1, 2, 3, 4, 5}, []int{3, 4, 5, 1, 2}},
		{[]int{2, 3, 4}, []int{3, 4, 3}}}
	for _, c := range testCases {
		t.Log(canCompleteCircuit(c.gas, c.cost))
	}

}
