package main

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */

func reorderList(head *ListNode) {
	qu := []*ListNode{}
	node := head
	for node != nil {
		qu = append(qu, node)
		node = node.Next
	}

	for i, j := 0, len(qu)-1; i < j; i, j = i+1, j-1 {
		qu[i].Next = qu[j]
		qu[j].Next = qu[i+1]
		qu[i+1].Next = nil
	}
}

func main() {
	testCases := [][]int{{1}, {1, 2}, {1, 2, 3, 4}, {1, 2, 3, 4, 5}}
	for _, testCase := range testCases {
		head := BuildList(testCase)
		reorderList(head)
		PrintList(head)
	}
}
