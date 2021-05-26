/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var neighbors: ArrayList<Node?> = ArrayList<Node?>()
 * }
 */

class Solution {
    fun cloneGraph(node: Node?): Node? {
        if (node == null) return null
        return dfs(node, HashMap())
    }

    private fun dfs(node: Node?, map: HashMap<Int, Node>): Node? {
        if (node == null) return null
        if (map.containsKey(node.`val`)) return map.getOrDefault(node.`val`, Node(node.`val`))
        val newNode = Node(node.`val`)
        map[newNode.`val`] = newNode
        for (i in node.neighbors) {
            newNode.neighbors.add(dfs(i, map))
        }
        return newNode
    }
}