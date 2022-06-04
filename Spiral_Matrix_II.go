package main

import "fmt"

func generateMatrix(n int) [][]int {
	matrix := [][]int{}
	if n <= 0 {
		return matrix
	}
	for i := 0; i < n; i++ {
		matrix = append(matrix, make([]int, n))
	}
	beginRow, endRow := 0, n-1
	beginCol, endCol := 0, n-1
	k := 1
	for beginRow <= endRow && beginCol <= endCol {
		for i := beginCol; i <= endCol; i++ {
			matrix[beginRow][i] = k
			k++
		}
		beginRow++

		for i := beginRow; i <= endRow; i++ {
			matrix[i][endCol] = k
			k++
		}
		endCol--

		for i := endCol; i >= beginCol; i-- {
			matrix[endRow][i] = k
			k++
		}
		endRow--

		for i := endRow; i >= beginRow; i-- {
			matrix[i][beginCol] = k
			k++
		}
		beginCol++
	}
	return matrix
}

func main() {
	testCases := []int{3, 5}
	for _, testCase := range testCases {
		fmt.Println(generateMatrix(testCase))
	}
}
