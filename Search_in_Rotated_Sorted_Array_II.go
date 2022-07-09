package main

func search(nums []int, target int) bool {
	if len(nums) == 0 {
		return false
	}
	if nums[0] == target || nums[len(nums)-1] == target {
		return true
	}
	pivot := findPivot(nums)
	// println(pivot)
	if pivot < 0 {
		return searchBetween(nums, 0, len(nums)-1, target)
	}
	if target < nums[0] {
		return searchBetween(nums, pivot, len(nums)-1, target)
	} else {
		return searchBetween(nums, 0, pivot-1, target)
	}
}

func findPivot(nums []int) int {
	left, right := 0, len(nums)-1
	for left < right && nums[left] == nums[left+1] {
		left++
	}
	for left < right && nums[right] == nums[right-1] {
		right--
	}
	pivot := -1

	for left < right {
		mid := (left + right) / 2
		if nums[mid] < nums[left] {
			right = mid
			pivot = right
		} else if nums[mid] > nums[right] {
			left = mid + 1
			pivot = left
		} else {
			break
		}
		// println(left, right)
	}
	return pivot
}

func searchBetween(nums []int, left, right, target int) bool {
	for left <= right {
		mid := (left + right) / 2
		if nums[mid] < target {
			left = mid + 1
		} else if nums[mid] > target {
			right = mid - 1
		} else {
			return true
		}
	}
	return false
}

type Testcase struct {
	nums   []int
	target int
}

func main() {
	testCases := []Testcase{{[]int{2, 5, 6, 0, 0, 1, 2}, 0},
		{[]int{2, 5, 6, 0, 0, 1, 2}, 3},
		{[]int{2, 5, 6, 0, 0, 1}, 1},
		{[]int{1, 0, 1, 1, 1}, 0},
		{[]int{4, 5, 6, 7, 0, 1, 2}, 0}}
	for _, testCase := range testCases {
		println(search(testCase.nums, testCase.target))
	}
}
