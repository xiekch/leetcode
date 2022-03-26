package main

func canCompleteCircuit(gas []int, cost []int) int {
	if len(gas) == 0 || len(cost) == 0 {
		return -1
	}

	n := len(gas)
	diff := make([]int, n)

	diff[0] = gas[0] - cost[0]
	sum := diff[0]
	for i := 1; i < n; i++ {
		diff[i] = gas[i] - cost[i]
		sum = sum + diff[i]
	}

	if sum < 0 {
		return -1
	}

	for i := 0; i < n; {
		fuel := 0
		k := i
		j := 1
		for ; j <= n; j++ {
			fuel += diff[k]
			if fuel < 0 {
				break
			}
			k = (k + 1) % n
		}
		if j > n {
			return i
		} else {
			i = i + j
		}
	}
	return -1
}
