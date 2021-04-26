
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
    private fun generateTrees(low: Int, high: Int): List<TreeNode?> {
        val res = mutableListOf<TreeNode?>()

        if (low > high) {
            // to let every below for-loop happens
            res.add(null)
        } else if (low == high) {
            res.add(TreeNode(low))
        } else {
            for (i in low..high) {
                val leftChildren = generateTrees(low, i - 1)
                val rightChildren = generateTrees(i + 1, high)
                for (l in leftChildren) {
                    for (r in rightChildren) {
                        val root = TreeNode(i)
                        root.left = l
                        root.right = r
                        res.add(root)
                    }
                }
            }
        }
        return res
    }

    fun generateTrees(n: Int): List<TreeNode?> {
        return generateTrees(1, n)
    }
}


fun main() {
    val solution = Solution()
    val testCases = arrayOf(3, 1, 5)
    for (case in testCases) {
        val res = solution.generateTrees(case)
        println(res.size)
        for (tree in res)
            TreeUtils.printTree(tree)
        println()
    }
}