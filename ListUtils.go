package main

import (
	"fmt"
)

type ListNode struct {
	Val  int
	Next *ListNode
}

func BuildList(values []int) *ListNode {
	var head, node *ListNode
	for _, i := range values {
		if head == nil {
			head = &ListNode{i, nil}
			node = head
		} else {
			node.Next = &ListNode{i, nil}
			node = node.Next
		}
	}
	return head
}

func PrintList(head *ListNode) {
	if head == nil {
		fmt.Println("nil")
		return
	}
	for head != nil {
		fmt.Printf("%d ", head.Val)
		head = head.Next
	}
	fmt.Println()
}

func ReverseList(head *ListNode) *ListNode {
	var prev, cur *ListNode
	cur = head
	for cur != nil {
		temp := cur.Next
		cur.Next = prev
		prev = cur
		cur = temp
	}

	return prev
}
