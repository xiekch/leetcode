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
class Solution {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        if (root == null) {
            return 0;
        }
        val st = Stack<TreeNode>()
        val pq = PriorityQueue<Int>()
        st.push(root)
        while (!st.isEmpty()) {
            val node = st.pop()
            pq.offer(node.`val`)
            if (node.left != null) {
                st.push(node.left)
            }
            if (node.right != null) {
                st.push(node.right)
            }
        }
        for (i in 1 until k) {
            println(pq.poll() ?: 0)
        }
        return pq.poll() ?: 0
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