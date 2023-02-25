package main

func maxRotateFunction(nums []int) int {
	delta := 0
	f0 := 0
	for i, n := range nums {
		delta += n
		f0 += i * n
	}

	ans := f0
	fLast := f0
	n := len(nums)
	for i := 1; i < n; i++ {
		fi := fLast + delta - n*nums[n-i]
		fLast = fi
		if ans < fi {
			ans = fi
		}
	}
	return ans
}

func main() {
	testCases := [][]int{{4, 3, 2, 6}, {100}}
	for _, testCase := range testCases {
		println(maxRotateFunction(testCase))
	}
}
