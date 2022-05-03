package main

import "fmt"

func longestValidParentheses(s string) int {
	st := []int{}
	for i, c := range s {
		if len(st) == 0 {
			st = append(st, i)
		} else {
			last := st[len(st)-1]
			if s[last] == '(' && c == ')' {
				st = st[:len(st)-1]
			} else {
				st = append(st, i)
			}
		}
	}
	if len(st) == 0 {
		return len(s)
	}

	res := st[0] - 0
	last := len(s)
	for i := len(st) - 1; i >= 0; i-- {
		if res < last-st[i]-1 {
			res = last - st[i] - 1
		}
		last = st[i]
	}
	return res
}

func main() {
	testCases := []string{"(()", ")()())", "", "(()((((())))))()()()))))(((()))))"}
	for _, testCase := range testCases {
		fmt.Println(longestValidParentheses(testCase))
	}
}
