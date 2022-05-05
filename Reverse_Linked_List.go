package main

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

func reverseList(head *ListNode) *ListNode {
	var prev *ListNode = nil
	for head != nil {
		prev, head.Next, head = head, prev, head.Next
	}
	return prev
}

func main() {
	testCases := [][]int{{1, 2, 3, 4, 5}}
	for _, testCase := range testCases {
		PrintList(reverseList(BuildList(testCase)))
	}
}
