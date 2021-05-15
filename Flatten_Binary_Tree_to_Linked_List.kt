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
    private var cur: TreeNode? = null
    fun flatten(root: TreeNode?): Unit {
        if (root == null) return
        if (cur != null) cur?.right = root
        cur = root
        val right = root.right
        root.right = null
        val left = root.left
        root.left = null
        flatten(left)
        flatten(right)
    }
}

fun main() {
    val solution = Solution()
    val testCases = arrayOf<Array<Int?>>(
        arrayOf(1, 2, 5, 3, 4, null, 6),
        arrayOf(),
        arrayOf(0)
    )
    for (testCase in testCases) {
        val root = TreeUtils.buildTree(testCase)
        solution.flatten(root)
        TreeUtils.printTree(root)
    }
}