package main

import (
	"fmt"
)

// Time Limit Exceeded
func findSubstring(s string, words []string) []int {
	var res = []int{}
	var wordsMap = map[string][]string{}
	var wordsLen = 0
	for _, word := range words {
		wordsLen += len(word)
		var listOfWords, ok = wordsMap[word[:1]]
		if ok {
			wordsMap[word[:1]] = append(listOfWords, word)
		} else {
			wordsMap[word[:1]] = []string{word}
		}
	}

	var sLen = len(s)
	for i := 0; i < sLen && sLen-i >= wordsLen; i++ {
		if checkMatch(s[i:], wordsMap, wordsLen) {
			res = append(res, i)
		}
	}
	return res
}

func checkMatch(s string, wordsMap map[string][]string, wordsLen int) bool {
	if wordsLen == 0 {
		return true
	}

	var ch = s[:1]
	listOfWords, ok := wordsMap[ch]
	if ok {
		for i, word := range listOfWords {
			var wordLen = len(word)
			if wordLen != 0 && word == s[:wordLen] {
				listOfWords[i] = ""
				if checkMatch(s[wordLen:], wordsMap, wordsLen-wordLen) {
					listOfWords[i] = word
					return true
				}
				listOfWords[i] = word
			}
		}
	}
	// fmt.Println("false check")

	return false
}

type TestCase struct {
	s     string
	words []string
}

func main() {
	var testCases = []TestCase{
		{s: "barfoothefoobarman", words: []string{"foo", "bar"}},
		{s: "wordgoodgoodgoodbestword", words: []string{"word", "good", "best", "word"}},
		{s: "barfoofoobarthefoobarman", words: []string{"bar", "foo", "the"}}}

	for _, testCase := range testCases {
		fmt.Println(findSubstring(testCase.s, testCase.words))
	}
}
