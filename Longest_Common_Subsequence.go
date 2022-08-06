package main

import "fmt"

func longestCommonSubsequence(text1 string, text2 string) int {
	res := 0
	dp := make([]int, len(text2)+1)
	last := make([]int, len(text2)+1)
	for i := range text1 {
		for j := 1; j <= len(text2); j++ {
			dp[j] = max(last[j], dp[j-1])
			if text1[i] == text2[j-1] {
				dp[j] = max(dp[j], last[j-1]+1)
				res = max(res, dp[j])
			}
		}
		dp, last = last, dp
	}
	// fmt.Println(dp)
	return res
}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func main() {
	testCases := [][]string{{"abcde", "ace"}, {"abc", "abc"}, {"abc", "def"}}
	for _, testCase := range testCases {
		fmt.Println(longestCommonSubsequence(testCase[0], testCase[1]))
	}
}
