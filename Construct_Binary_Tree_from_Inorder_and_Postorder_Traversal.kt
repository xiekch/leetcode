/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        return buildTree(inorder, 0, inorder.size, postorder, 0, postorder.size)
    }

    private fun buildTree(
        inorder: IntArray,
        inStart: Int,
        inEnd: Int,
        postorder: IntArray,
        postStart: Int,
        postEnd: Int
    ): TreeNode? {
        if (inStart == inEnd) return null
        var rootIndex = -1
        for (i in inStart until inEnd) {
            if (inorder[i] == postorder[postEnd - 1]) {
                rootIndex = i
                break
            }
        }
        if (rootIndex == -1) return null
        val root = TreeNode(postorder[postEnd - 1])
        root.left = buildTree(
            inorder,
            inStart,
            rootIndex,
            postorder,
            postStart,
            postStart + rootIndex - inStart
        )
        root.right = buildTree(
            inorder,
            rootIndex + 1,
            inEnd,
            postorder,
            postStart + rootIndex - inStart,
            postEnd - 1
        )
        return root
    }
}


fun main() {
    class TestCase(val inorder: IntArray, val postorder: IntArray)

    val solution = Solution()
    val testCases = arrayOf(
        TestCase(intArrayOf(9, 3, 15, 20, 7), intArrayOf(9, 15, 7, 20, 3)),
        TestCase(intArrayOf(-1), intArrayOf(-1)),
        TestCase(intArrayOf(), intArrayOf())
    )
    for (case in testCases) {
        val root = solution.buildTree(case.inorder, case.postorder)
        TreeUtils.printTree(root)
    }
}