package main

import "fmt"

func lengthOfLongestSubstring(s string) int {
	cMap := make(map[byte]bool)
	res := 0
	for i, j := 0, 0; j < len(s); {
		if !cMap[s[j]] {
			cMap[s[j]] = true
			j++
			res = max(res, j-i)
		} else {
			for s[i] != s[j] {
				cMap[s[i]] = false
				i++
			}
			cMap[s[i]] = false
			i++
		}
	}
	return res
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func main() {
	testCases := []string{"abcabcbb", "bbbbb", "pwwkew"}
	for _, testCase := range testCases {
		fmt.Println(lengthOfLongestSubstring(testCase))
	}
}
