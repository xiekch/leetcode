package main

func twoSum(numbers []int, target int) []int {
	for left, right := 0, len(numbers)-1; ; {
		l, r := numbers[left], numbers[right]
		if l+r > target {
			right--
		} else if l+r < target {
			left++
		} else {
			return []int{left + 1, right + 1}
		}
	}
	return []int{-1, -1}
}
