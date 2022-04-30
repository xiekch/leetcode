package main

// import "fmt"

func isValidSudoku(board [][]byte) bool {
	arr := make([]byte, 9)
	for i := 0; i < 9; i++ {
		// row
		if !isDistinct(board[i]) {
			return false
		}
		// column
		for j := 0; j < 9; j++ {
			arr[j] = board[j][i]
		}
		if !isDistinct(arr) {
			return false
		}
		// square
		for j := 0; j < 9; j++ {
			arr[j] = board[(i/3)*3+j/3][(i%3)*3+j%3]
			// fmt.Print((i/3)*3 + j/3)
			// fmt.Print((i%3)*3+j%3, " ")
		}
		if !isDistinct(arr) {
			return false
		}
	}

	return true
}

func isDistinct(arr []byte) bool {
	used := [10]bool{}
	for _, n := range arr {
		if n == '.' {
			continue
		}
		if used[n-'0'] == false {
			used[n-'0'] = true
		} else {
			// for _, j := range arr {
			// 	if j == '.' {
			// 		fmt.Print(". ")
			// 	} else {
			// 		fmt.Print(j-'0', " ")
			// 	}
			// }
			return false
		}
	}
	return true
}

func main() {
	testCases := [][][]byte{
		{{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
			{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
			{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
			{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
			{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
			{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
			{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
			{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
			{'.', '.', '.', '.', '8', '.', '.', '7', '9'}},
		{{'8', '3', '.', '.', '7', '.', '.', '.', '.'},
			{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
			{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
			{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
			{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
			{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
			{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
			{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
			{'.', '.', '.', '.', '8', '.', '.', '7', '9'}}}
	for _, testCase := range testCases {
		println(isValidSudoku(testCase))
	}
}
