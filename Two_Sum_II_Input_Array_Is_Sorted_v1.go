package main

func twoSum(numbers []int, target int) []int {
	for i, n := range numbers {
		if target-n < n {
			break
		}
		if res := findNum(numbers, target-n, i+1, len(numbers)-1); res != -1 {
			return []int{i + 1, res + 1}
		}
	}
	return []int{-1, -1}
}

func findNum(numbers []int, target, start, end int) int {
	if start > end || start >= len(numbers) || end >= len(numbers) {
		return -1
	}

	for start <= end {
		mid := (start + end) / 2
		num := numbers[mid]
		if num == target {
			return mid
		} else if num < target {
			start = mid + 1
		} else {
			end = mid - 1
		}
	}
	return -1
}
