package main

func isUgly(n int) bool {
	if n <= 0 {
		return false
	}

	if n == 1 {
		return true
	}

	primes := []int{2, 3, 5}
	for _, i := range primes {
		for n%i == 0 {
			n /= i
			// println(n, i)
		}
	}

	return n == 1
}

func main() {
	testCases := []int{6, 1, 14, 0}
	for _, testCase := range testCases {
		println(isUgly(testCase))
	}
}
