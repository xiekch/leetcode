package main

import (
	"math"
)

// type TreeNode struct {
// 	Val int
// 	Left *TreeNode
// 	Right *TreeNode
// }

func countNodes(root *TreeNode) int {
	nodes, _ := countNodesAndLevel(root)
	return nodes
}

func countNodesAndLevel(root *TreeNode) (int, int) {
	if root == nil {
		return 0, 0
	}
	if root.Left != nil && root.Right != nil {
		rightNodes, rightLevel := countNodesAndLevel(root.Right)
		fullTreeNodes := int(math.Pow(2, float64(rightLevel))) - 1
		if rightNodes == fullTreeNodes {
			leftNodes, leftLevel := countNodesAndLevel(root.Left)
			// println(leftNodes, leftLevel, rightNodes, rightLevel)
			return leftNodes + rightNodes + 1, max(leftLevel, rightLevel) + 1
		} else {
			// println(rightNodes, rightLevel)
			return rightNodes + fullTreeNodes + 1, (rightLevel) + 1
		}
	} else if root.Left == nil && root.Right == nil {
		return 1, 1
	} else {
		leftNodes, leftLevel := countNodesAndLevel(root.Left)
		return leftNodes + 1, leftLevel + 1
	}
}

func max(a, b int) int {
	if a >= b {
		return a
	}
	return b
}

func main() {
	testCases := [][]int{{1, 2, 3, 4, 5, 6}, {}, {1}, {1, 2, 3, 4, 5},
		{1, 2, 3, 4, 5, 6, 7}, {1, 2, 3, 4, 5, 6, 7, 8}}
	for _, testCase := range testCases {
		println(countNodes(buildTree(testCase)))
	}
}
