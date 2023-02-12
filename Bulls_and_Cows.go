package main

import (
	"fmt"
	"strconv"
)

func getHint(secret string, guess string) string {
	secretsNums := map[int]int{}

	var bulls, cows = 0, 0
	for i, n := range secret {
		if secret[i] == guess[i] {
			bulls++
		}
		secretsNums[(int(n)-'0')]++
	}

	for _, n := range guess {
		if secretsNums[int(n)-'0'] > 0 {
			secretsNums[int(n)-'0']--
			cows++
		}
	}
	cows -= bulls

	return strconv.Itoa(bulls) + "A" + strconv.Itoa(cows) + "B"
}

func main() {
	testCases := [][]string{{"1807", "7810"}, {"1123", "0111"}, {"11", "11"}}
	for _, testCase := range testCases {
		fmt.Println(getHint(testCase[0], testCase[1]))
	}

}
