package main

import (
	"fmt"
)

func findSubstring(s string, words []string) []int {
	var res = []int{}
	var wordsLen = len(words)
	var wordLen = len(words[0])
	if len(words) == 0 || wordLen*wordsLen > len(s) {
		return res
	}

	var wordsMap = map[string]int{}
	for _, word := range words {
		wordsMap[word] = wordsMap[word] + 1
	}
	fmt.Println(wordsMap)

	var sLen = len(s)
	for i := 0; i <= sLen-wordsLen*wordLen; i++ {
		if check(s[i:], wordsMap, wordsLen, wordLen) {
			res = append(res, i)
		}
	}
	return res
}

func check(s string, wordsMap map[string]int, wordsLen int, wordLen int) bool {
	newWordsMap := map[string]int{}
	for k, v := range wordsMap {
		newWordsMap[k] = v
	}
	for i := 0; i < wordsLen; i++ {
		word := s[i*wordLen : (i+1)*wordLen]
		if newWordsMap[word] != 0 {
			newWordsMap[word] -= 1
		} else {
			return false
		}
	}

	return true
}

type TestCase struct {
	s     string
	words []string
}

func main() {
	var testCases = []TestCase{
		{s: "barfoothefoobarman", words: []string{"foo", "bar"}},
		{s: "wordgoodgoodgoodbestword", words: []string{"word", "good", "best", "word"}},
		{s: "barfoofoobarthefoobarman", words: []string{"bar", "foo", "the"}},
		{s: "wordgoodgoodgoodbestword", words: []string{"word", "good", "best", "good"}},
		{s: "abababababababaabababababababababababababababaababababababababababababababababaababababababababababababababababababababababababababababababababababababababababababab",
			words: []string{"ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab", "ba", "ab"}}}

	for _, testCase := range testCases {
		fmt.Println(findSubstring(testCase.s, testCase.words))
	}
}
