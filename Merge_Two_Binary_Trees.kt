// Example:
// var ti = TreeNode(5)
// var v = ti.`val`
// Definition for a binary tree node.

//class TreeNode(var `val`: Int) {
//    var left: TreeNode? = null
//    var right: TreeNode? = null
//}

class Solution {
    fun mergeTrees(t1: TreeNode?, t2: TreeNode?): TreeNode? {
        if (t1 == null) {
            return t2
        }
        if (t2 == null) {
            return t1
        }
        val root = TreeNode(t1.`val` + t2.`val`)
        root.left = mergeTrees(t1.left, t2.left)
        root.right = mergeTrees(t1.right, t2.right)
        return root
    }
}

fun main(args: Array<String>) {
    val testsetA = arrayOf(
        arrayOf("1", "3", "2", "5")
    )
    val testsetB = arrayOf(
        arrayOf("2", "1", "3", "null", "4", "null", "7")
    )
    for (i in 1..testsetA.lastIndex) {
        val solution = Solution()
        val left = TreeUtils.buildTree(testsetA[i])
        TreeUtils.printTree(left)
        val right = TreeUtils.buildTree(testsetB[i])
        TreeUtils.printTree(right)
        TreeUtils.printTree(solution.mergeTrees(left, right))
    }
}
