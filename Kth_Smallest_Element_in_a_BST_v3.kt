import java.util.*

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
// inorder traversal of BST
class Solution {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        if (root == null) {
            return 0;
        }
        val st = Stack<TreeNode>()
        var node = root
        var count = 0
        while (true) {
            while (node != null) {
                st.push(node)
                node = node.left
            }
            node = st.pop()
            if (++count == k) {
                return node.`val`
            }
            node = node.right
        }
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    val testset = arrayOf(
        arrayOf("3", "1", "4", "null", "2"),
        arrayOf("5", "3", "6", "2", "4", "null", "null", "1")
    )
    val ks = intArrayOf(1, 3)
    for (i in 0..testset.lastIndex) {
        val root = TreeUtils.buildTree(testset[i])
        TreeUtils.printTree(root)
        println(solution.kthSmallest(root, ks[i]))
    }
}