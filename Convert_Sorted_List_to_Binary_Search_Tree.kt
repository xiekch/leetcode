/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
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
    fun sortedListToBST(head: ListNode?): TreeNode? {
        if (head == null) return null
        val array = ArrayList<TreeNode>()
        var node = head
        while (node != null) {
            array.add(TreeNode(node.`val`))
            node = node.next
        }

        return connectTreeNodes(array, 0, array.size)
    }

    private fun connectTreeNodes(array: ArrayList<TreeNode>, start: Int, end: Int): TreeNode? {
        if (start >= end) return null
        val mid = (start + end) / 2
        val root = array[mid]
        root.left = connectTreeNodes(array, start, mid)
        root.right = connectTreeNodes(array, mid + 1, end)
        return root
    }
}

fun main() {
    val solution = Solution()
    val testCases = arrayOf(
        intArrayOf(-10, -3, 0, 5, 9),
        intArrayOf(),
        intArrayOf(1),
        intArrayOf(1,3)
    )
    for (testCase in testCases) {
        val res = solution.sortedListToBST(ListUtils.buildList(testCase))
        TreeUtils.printTree(res)
    }
}