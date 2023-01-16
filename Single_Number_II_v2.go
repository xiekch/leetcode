package main

/**
DFA: Deterministic Finite State
https://leetcode.cn/problems/single-number-ii/solution/gong-shui-san-xie-yi-ti-san-jie-ha-xi-bi-fku8/
ab| n 0   1
00    00   01
01    01   10
11    00   00
10    10   00
*/

func singleNumber(nums []int) int {
	var a, b int = 0, 0
	for _, n := range nums {
		c := a
		a = (a &^ b &^ n) | (^a & b & n)
		b = (^c & b &^ n) | (^c &^ b & n)
	}
	return b
}

func main() {
	var testCases = [][]int{
		{2, 2, 3, 2},
		{0, 1, 0, 1, 0, 1, 99},
		{-1, -1, -1, -2},
		{-2, -2, 1, 1, 4, 1, 4, 4, -4, -2},
		{2, 2, 2, -1, -1, -1, 8, -7, 0, -7, 0, -7, 0}}
	for _, testCase := range testCases {
		println(singleNumber(testCase))
		println()
	}
}
