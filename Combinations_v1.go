package main

import "fmt"

func combine(n int, k int) [][]int {
	res := [][]int{}
	if n < k {
		return res
	}
	if n == k {
		ele := []int{}
		for i := 1; i <= n; i++ {
			ele = append(ele, i)
		}
		res = append(res, ele)
		return res
	}

	if k > 1 {
		containCur := combine(n-1, k-1)
		for _, i := range containCur {
			i = append(i, n)
			res = append(res, i)
		}
	} else if k == 1 {
		res = append(res, []int{n})
	}

	if n > 1 {
		notContainCur := combine(n-1, k)
		res = append(res, notContainCur...)
	}
	return res
}

func main() {
	testCases := [][]int{{4, 2}}
	for _, i := range testCases {
		fmt.Println(combine(i[0], i[1]))
	}
}
