package main

import "fmt"

func spiralOrder(matrix [][]int) []int {
	ans := []int{}
	m := len(matrix)
	if m == 0 {
		return ans
	}
	n := len(matrix[0])
	if n == 0 {
		return ans
	}
	rowBegin, colBegin := 0, 0
	rowEnd, colEnd := m-1, n-1
	for rowBegin <= rowEnd && colBegin <= colEnd {
		for i := colBegin; i <= colEnd; i++ {
			ans = append(ans, matrix[rowBegin][i])
		}
		rowBegin++

		for i := rowBegin; i <= rowEnd; i++ {
			ans = append(ans, matrix[i][colEnd])
		}
		colEnd--

		for i := colEnd; i >= colBegin && rowBegin <= rowEnd; i-- {
			ans = append(ans, matrix[rowEnd][i])
		}
		rowEnd--

		for i := rowEnd; i >= rowBegin && colBegin <= colEnd; i-- {
			ans = append(ans, matrix[i][colBegin])
		}
		colBegin++
	}

	return ans
}

func main() {
	testCases := [][][]int{{{1}, {2}, {3}},
		{{2}, {3}},
		{{2, 5, 8}, {4, 0, -1}},
		{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
		{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}},
		{{1, 2}, {4, 5}, {7, 8}, {10, 11}}}
	for _, testCase := range testCases {
		fmt.Println(spiralOrder(testCase))
	}
}
