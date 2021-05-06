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
        val qu = LinkedList<Node>()
        qu.add(root)
        while (!qu.isEmpty()) {
            val size = qu.size
            for (i in 0 until size) {
                val node = qu.poll()
                if (i != size - 1)
                    node?.next = qu.peek()

                node?.left?.let {
                    qu.add(it)
                }
                node?.right?.let {
                    qu.add(it)
                }
            }
        }
        return root
    }
}