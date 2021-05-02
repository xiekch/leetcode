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
    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
        val res: ArrayList<List<Int>> = ArrayList()
        dfs(root, targetSum, ArrayList(), res)
        return res
    }

    private fun dfs(
        root: TreeNode?,
        cur: Int,
        path: ArrayList<Int>,
        res: ArrayList<List<Int>>
    ) {
        if (root == null) return
        path.add(root.`val`)
        if (root.right == null && root.left == null && cur == root.`val`) {
            res.add(path.toList())
        } else {
            dfs(root.left, cur - root.`val`, path, res)
            dfs(root.right, cur - root.`val`, path, res)
        }
        path.removeAt(path.lastIndex)
    }
}

fun main() {
    data class TestCase(val root: Array<Int?>, val targetSum: Int)

    val solution = Solution()
    val testCases = arrayOf(
        TestCase(arrayOf(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1), 22),
        TestCase(arrayOf(1, 2, 3), 3),
        TestCase(arrayOf(1, 2), 0),
        TestCase(arrayOf(-2, null, -3), -5)
    )
    for (case in testCases) {
        val res = solution.pathSum(TreeUtils.buildTree(case.root), case.targetSum)
        for (i in res)
            println(i.joinToString(" "))
    }
}