package main

func countPrimes(n int) int {
	if n <= 2 {
		return 0
	}
	count := 1
	primes := []int{2}
	for i := 3; i < n; i += 2 {
		flag := true
		for _, p := range primes {
			if p*p > i {
				break
			}
			if i%p == 0 {
				flag = false
				break
			}
		}
		if flag {
			primes = append(primes, i)
			count++
		}
	}
	return count
}

func main() {
	testCases := []int{10, 0, 1, 10000}
	for _, testCase := range testCases {
		println(countPrimes(testCase))
	}
}
