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
    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        val res = ArrayList<ArrayList<Int>>()
        if (root == null) return res
        val qu = LinkedList<TreeNode>()
        qu.push(root)
        var size = qu.size
        var level = 0
        var even = true
        while (!qu.isEmpty()) {
            res.add(ArrayList())
            for (i in 1..size) {
                val node = qu.poll()
                res[level].add(node.`val`)
                if (node.left != null) qu.add(node.left!!)
                if (node.right != null) qu.add(node.right!!)
            }
            if (!even) res[level].reverse()
            even = !even
            size = qu.size
            level++
        }
        return res
    }
}


fun main() {
    val solution = Solution()
    val testCases =
        arrayOf(
            arrayOf("3", "9", "20", "null", "null", "15", "7"), arrayOf("6", "5", "4", "8"),
            arrayOf("1"), arrayOf("")
        )
    for (case in testCases) {
        val root = TreeUtils.buildTree(case)
        TreeUtils.printTree(root)
        println(solution.zigzagLevelOrder(root).joinToString())
    }
}