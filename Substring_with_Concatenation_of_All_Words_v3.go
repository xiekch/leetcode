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

	for i := 0; i < wordLen; i++ {
		subRes := slidingWindow(s, i, wordsMap, wordsLen, wordLen)
		for _, r := range subRes {
			res = append(res, r)
		}
	}
	return res
}

func slidingWindow(s string, left int, wordsMap map[string]int, wordsLen int, wordLen int) []int {
	res := []int{}
	wordsFound := map[string]int{}
	excessWord := false

	var wordsUsedCount = 0
	for right := left; right+wordLen <= len(s); right += wordLen {
		word := s[right : right+wordLen]
		// fmt.Println(word, wordsUsedCount, wordsFound)

		if wordsMap[word] == 0 {
			wordsFound = map[string]int{}
			wordsUsedCount = 0
			excessWord = false
			left = right + wordLen
		} else {
			for right-left == wordsLen*wordLen || excessWord {
				firstWord := s[left : left+wordLen]
				left += wordLen
				wordsFound[firstWord] -= 1
				if wordsFound[firstWord] >= wordsMap[firstWord] {
					// we removed the excess word
					excessWord = false
				} else {
					wordsUsedCount--
				}
			}

			wordsFound[word] += 1
			if wordsFound[word] <= wordsMap[word] {
				wordsUsedCount++
			} else {
				excessWord = true
			}

			if wordsUsedCount == wordsLen && !excessWord {
				res = append(res, left)
			}
		}
	}
	return res
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
