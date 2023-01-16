package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func buildTree(nums []int) *TreeNode {
	if len(nums) == 0 {
		return nil
	}
	root := &TreeNode{nums[0], nil, nil}
	qu := []*TreeNode{root}
	i := 1
	for i < len(nums) && len(qu) > 0 {
		node := qu[0]
		qu = qu[1:]
		leftNode := &TreeNode{nums[i], nil, nil}
		node.Left = leftNode
		qu = append(qu, leftNode)

		i++
		if i < len(nums) {
			rightNode := &TreeNode{nums[i], nil, nil}
			node.Right = rightNode
			qu = append(qu, rightNode)
		}
		i++
	}

	return root
}
