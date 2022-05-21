package main

import "fmt"

func combine(n int, k int) [][]int {
	res := [][]int{}
	generateCombine(&res, []int{}, n, k, 1)
	return res
}

func generateCombine(res *[][]int, cur []int, n, k, start int) {
	if len(cur) == k {
		b := make([]int, len(cur))
		copy(b, cur)
		*res = append(*res, b)
		return
	}
	for i := start; i <= n-(k-len(cur))+1; i++ {
		cur = append(cur, i)
		generateCombine(res, cur, n, k, i+1)
		cur = cur[:len(cur)-1]
	}
}

func main() {
	testCases := [][]int{{4, 2}}
	for _, i := range testCases {
		fmt.Println(combine(i[0], i[1]))
	}
}
