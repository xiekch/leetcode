package main

// Time Limit Exceeded
func canCompleteCircuit(gas []int, cost []int) int {
	if len(gas) == 0 || len(cost) == 0 {
		return -1
	}

	n := len(gas)
	sum := make([]int, n)

	for i := 0; i < n; i++ {
		sum[i] = gas[i] - cost[i]
	}

	for i := 0; i < n; i++ {
		acc := 0
		k := i
		flag := true
		for j := 0; j < n; j++ {
			acc += sum[k]
			if acc < 0 {
				flag = false
				break
			}
			k = (k + 1) % n
		}
		if flag {
			return i
		}
	}
	return -1
}
