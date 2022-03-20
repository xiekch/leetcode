package main

import (
	"fmt"
	"math/rand"
	"sort"
	"time"
)

func QuickSortRecursion(arr []int, begin, end int) {
	if begin >= end-1 {
		return
	}
	pivot := arr[begin]
	left, right := begin, end-1

	for left < right {
		for left < right && arr[right] > pivot {
			right--
		}
		arr[left] = arr[right]

		for left < right && arr[left] <= pivot {
			left++
		}
		arr[right] = arr[left]
	}
	arr[left] = pivot

	// fmt.Println(arr, begin, end, left, pivot)
	// time.Sleep(3 * time.Second)

	QuickSortRecursion(arr, begin, left)
	QuickSortRecursion(arr, left+1, end)
}

func QuickSortNotRecursion(arr []int, begin, end int) {
	if begin >= end-1 {
		return
	}

	stack := [][]int{{begin, end}}

	for len(stack) != 0 {
		r := stack[len(stack)-1]
		stack = stack[:len(stack)-1]
		begin, end = r[0], r[1]
		if begin >= end-1 {
			continue
		}
		left, right := begin, end-1
		pivot := arr[begin]
		for left < right {
			for left < right && arr[right] > pivot {
				right--
			}
			arr[left] = arr[right]

			for left < right && arr[left] <= pivot {
				left++
			}
			arr[right] = arr[left]
			// fmt.Println(arr, begin, end, left, right, pivot)
			// time.Sleep(1 * time.Second)
		}
		arr[left] = pivot
		stack = append(stack, []int{begin, left})
		stack = append(stack, []int{left + 1, end})
	}
}

func generateRandomArr() []int {
	size := rand.Intn(100)
	arr := make([]int, size)
	for i := 0; i < size; i++ {
		arr[i] = rand.Intn(100)
	}
	return arr
}

func checkAnswer(a, b []int) bool {
	if len(a) != len(b) {
		return false
	}
	for i := range a {
		if a[i] != b[i] {
			return false
		}
	}

	return true
}

func main() {
	rand.Seed(time.Now().Unix())
	for i := 0; i < 10; i++ {
		// testCaseA := []int{6, 4, 52, 10, 3, 7, 1}
		testCaseA := generateRandomArr()
		testCaseB := make([]int, len(testCaseA))
		testCaseRes := make([]int, len(testCaseA))
		copy(testCaseB, testCaseA)
		copy(testCaseRes, testCaseA)
		QuickSortRecursion(testCaseA, 0, len(testCaseA))
		QuickSortNotRecursion(testCaseB, 0, len(testCaseB))
		sort.Sort(sort.IntSlice(testCaseRes))
		fmt.Printf("check QuickSortRecursion %v\n", checkAnswer(testCaseA, testCaseRes))
		fmt.Printf("check QuickSortNotRecursion %v\n", checkAnswer(testCaseB, testCaseRes))
	}
}
