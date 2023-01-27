package main

import (
	"fmt"
	"sort"
)

func nthUglyNumber(n int) int {
	if n <= 1 {
		return 1
	}
	primes := []int{2, 3, 5}
	set := map[int]bool{}
	count := 1
	qu := []int{1}
	temp := []int{}
	finded := false
	upperBound := 0
	uglyNums := []int{1}

	for len(qu) != 0 {
		for _, q := range qu {
			for _, p := range primes {
				pq := q * p
				if finded && pq >= upperBound {
					break
				}
				if _, ok := set[pq]; ok {
					continue
				}
				set[pq] = true
				temp = append(temp, pq)
				count++
				uglyNums = append(uglyNums, pq)
				if pq > upperBound {
					upperBound = pq
				}
				if count == n {
					finded = true
					// fmt.Println(uglyNums, upperBound)
				}
			}
		}
		// fmt.Println(qu, temp)
		qu, temp = temp, qu
		temp = temp[:0]
	}
	sort.Sort(sort.IntSlice(uglyNums))
	// fmt.Println(uglyNums, count, n, upperBound)

	return uglyNums[n-1]
}

func main() {
	testCases := []int{10, 1, 100, 1650}
	for _, testCase := range testCases {
		fmt.Println(nthUglyNumber(testCase))
	}
}
