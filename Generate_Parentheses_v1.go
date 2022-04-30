package main

import "fmt"

func generateParenthesis(n int) []string {
	if n <= 0 {
		return []string{}
	}
	if n == 1 {
		return []string{"()"}
	}

	var generate func(int, int, int, int) []string
	generate = func(beforeLeft, beforeRight, left, right int) []string {
		res := []string{}
		// println(left, right)
		if left > right || left == 0 && right == 0 {
			return res
		}
		if right == 1 && left == 1 {
			res = append(res, "()")
			return res
		}
		if left == 0 {
			var r string
			for i := right; i > 0; i-- {
				r = ")" + r
			}
			res = append(res, r)
			return res
		}
		leftNext := generate(beforeLeft+1, beforeRight, left-1, right)
		for _, l := range leftNext {
			res = append(res, "("+l)
		}
		if beforeLeft > beforeRight {
			rightNext := generate(beforeLeft, beforeRight+1, left, right-1)
			for _, r := range rightNext {
				res = append(res, ")"+r)
			}
		}
		return res
	}

	return generate(0, 0, n, n)
}

func main() {
	testCases := []int{1, 2, 3, 4}
	for _, t := range testCases {
		fmt.Println(generateParenthesis(t))
	}
}
