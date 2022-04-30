package main

import "fmt"

func generateParenthesis(n int) []string {
	res := []string{}
	if n <= 0 {
		return res
	}
	generate(n, 0, 0, "", &res)
	return res
}

func generate(total, left, right int, cur string, res *[]string) {
	// println(left, right)
	if right > total || left > total {
		return
	}
	if total == right && total == left {
		*res = append(*res, cur)
		return
	}

	generate(total, left+1, right, cur+"(", res)
	if left > right {
		generate(total, left, right+1, cur+")", res)
	}
}

func main() {
	testCases := []int{1, 2, 3, 4}
	for _, t := range testCases {
		fmt.Println(generateParenthesis(t))
	}
}
