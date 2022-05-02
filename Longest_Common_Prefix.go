package main

func longestCommonPrefix(strs []string) string {
	if len(strs) == 0 || len(strs[0]) == 0 {
		return ""
	}

	for i := 0; ; i++ {
		for _, s := range strs {
			if i >= len(s) || s[i] != strs[0][i] {
				return strs[0][:i]
			}
		}
	}
	return ""
}

func main() {
	testCases := [][]string{{"flower", "flow", "flight"}, {"dog", "racecar", "car"}}
	for _, testCase := range testCases {
		println(longestCommonPrefix(testCase))
	}
}
