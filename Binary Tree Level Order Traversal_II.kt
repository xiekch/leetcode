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
    fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
        val res = mutableListOf<MutableList<Int>>()
        dfs(root, 0, res)
        return res.reversed()
    }

    private fun dfs(root: TreeNode?, level: Int, res: MutableList<MutableList<Int>>) {
        if (root == null) return
        if (level == res.size) res.add(mutableListOf())
        res[level].add(root.`val`)
        dfs(root.left, level + 1, res)
        dfs(root.right, level + 1, res)
    }
}

fun main() {
    val solution = Solution()
    val testCases = arrayOf<Array<Int?>>(
        arrayOf(3, 9, 20, null, null, 15, 7),
        arrayOf(1),
        arrayOf()
    )
    for (case in testCases) {
        val res = solution.levelOrderBottom(TreeUtils.buildTree(case))
        println(res.joinToString(","))
    }
}