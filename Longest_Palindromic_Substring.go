package main

import "fmt"

func longestPalindrome(s string) string {
	if len(s) <= 1 {
		return s
	}
	news := make([]rune, 0)
	news = append(news, '*')
	for _, c := range s {
		news = append(news, c)
		news = append(news, '*')
	}
	dp := make([]int, len(news))
	radius := 0
	pivot := 0
	maxLen := 0
	mid := 0
	// print(" ")
	for i := range dp {
		// print(string(news[i]), " ")
		if radius+pivot > i {
			dp[i] = min(pivot+radius-i, dp[pivot-(i-pivot)])
		} else {
			dp[i] = 1
		}

		left, right := i-dp[i], i+dp[i]
		for left >= 0 && right < len(news) && news[left] == news[right] {
			dp[i]++
			left--
			right++
		}

		// fmt.Println(i, dp[i], pivot, radius)

		if dp[i] > maxLen {
			maxLen = dp[i]
			mid = i
		}
		if dp[i]+i > pivot+radius {
			pivot = i
			radius = dp[i]
		}
	}
	// println()
	// fmt.Println(dp)
	return s[(mid-maxLen+1)/2 : (mid-maxLen+1)/2+maxLen-1]
}

func min(a, b int) int {
	if a > b {
		return b
	}
	return a
}

func main() {
	testCases := []string{"abccccdd", "a", "bb", "babad", "babadada"}
	for _, testCase := range testCases {
		fmt.Println(longestPalindrome(testCase))
	}
}
