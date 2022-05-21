package main

import "fmt"

func longestPalindrome(s string) int {
	m := make(map[byte]int)
	for i := range s {
		m[s[i]]++
	}
	res := 0
	odd := false
	for _, v := range m {
		if v%2 != 0 {
			if odd {
				res += v - 1
			} else {
				odd = true
				res += v
			}
		} else {
			res += v
		}
	}

	return res
}

func main() {
	testCases := []string{"abccccdd", "a", "bb", "bbbccc"}
	for _, testestCase := range testCases {
		fmt.Println(longestPalindrome(testestCase))
	}
}
