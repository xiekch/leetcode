package main

func countPrimes(n int) int {
	if n <= 2 {
		return 0
	}
	count := n / 2
	isComposite := make([]bool, n)

	for i := 3; i < n; i += 2 {
		if !isComposite[i] {
			for j := i * i; j < n; j += 2 * i {
				if !isComposite[j] {
					// println(j)
					count--
					isComposite[j] = true
				}
			}
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
