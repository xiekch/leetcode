package main

import (
	"fmt"
)

func findDiagonalOrder(mat [][]int) []int {
	res := []int{}
	if mat == nil {
		return res
	}
	m := len(mat)
	if m == 0 {
		return res
	}
	n := len(mat[0])
	if n == 0 {
		return res
	}

	// 0-0 0-1 1-0 2-0 1-1 0-2
	res = make([]int, m*n)
	res[0] = mat[0][0]

	for i, j, k := 0, 0, 0; !(i == m-1 && j == n-1); {
		if j < n-1 {
			j++
			k++
			res[k] = mat[i][j]
		} else if i < m-1 {
			i++
			k++
			res[k] = mat[i][j]
		}

		for j > 0 && i < m-1 {
			i++
			j--
			k++
			res[k] = mat[i][j]
		}

		if i < m-1 {
			i++
			k++
			res[k] = mat[i][j]
		} else if j < n-1 {
			j++
			k++
			res[k] = mat[i][j]
		}
		for i > 0 && j < n-1 {
			j++
			i--
			k++
			res[k] = mat[i][j]
		}
		// fmt.Println(res, i, j, m-1, n-1, !(i == n-1 && j == m-1))
	}

	return res
}

func main() {
	testCases := [][][]int{{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}},
		{{1, 2}, {3, 4}},
		{{0}},
		{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}, {101, 11, 12}}}
	for _, testCase := range testCases {
		fmt.Println(findDiagonalOrder(testCase))
		println()
	}
}
