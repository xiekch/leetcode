/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var left: Node? = null
 *     var right: Node? = null
 *     var next: Node? = null
 * }
 */

class Solution {
    fun connect(root: Node?): Node? {
        if (root == null) return null
        connect(root, 0, ArrayList())
        return root
    }

    private fun connect(node: Node, level: Int, levels: ArrayList<Node>) {
        if (level >= levels.size) levels.add(node)
        else {
            levels[level].next = node
            levels[level] = node
        }
        node.left?.let { connect(it, level + 1, levels) }
        node.right?.let { connect(it, level + 1, levels) }
    }
}