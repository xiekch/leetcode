package main

var m = map[int]int{}

func numRollsToTarget(n int, k int, target int) int {
	if target < n || n*k < target {
		return 0
	}
	// println(n, k, target)

	if n == 1 {
		return 1
	}
	hash := n*100000 + k*1000 + target
	if m[hash] != 0 {
		return m[hash]
	}
	res := 0
	i := 1
	if target-(n-1)*k > i {
		i = target - (n-1)*k
	}
	max := k
	if target-n+1 < max {
		max = target - n + 1
	}
	for ; i <= max; i++ {
		res += numRollsToTarget(n-1, k, target-i)
	}
	res = res % (1e9 + 7)
	m[hash] = res
	return res
}

func main() {
	testCases := [][]int{{1, 6, 3}, {2, 6, 7}, {3, 3, 6}, {30, 30, 500}}
	for _, testCase := range testCases {
		println(numRollsToTarget(testCase[0], testCase[1], testCase[2]))
	}
}
