import java.util.*
import kotlin.collections.HashSet

// Time Limit Exceeded
class Node(val left: Int, val right: Int, val x: Int, val level: Int)
class Solution {
    fun minOperations(nums: IntArray, x: Int): Int {
        val queue = LinkedList<Node>()
        val visited = HashSet<Pair<Int, Int>>()
        queue.push(Node(0, nums.size - 1, x, 0))
        while (!queue.isEmpty()) {
            val node = queue.pollLast()
            if (node.x == 0) return node.level
            if (node.x < 0 || node.left > node.right) continue
            if (!visited.contains(Pair(node.left + 1, node.right))) {
                visited.add(Pair(node.left + 1, node.right))
                queue.push(Node(node.left + 1, node.right, node.x - nums[node.left], node.level + 1))
            }
            if (!visited.contains(Pair(node.left, node.right - 1))) {
                visited.add(Pair(node.left, node.right - 1))
                queue.push(Node(node.left, node.right - 1, node.x - nums[node.right], node.level + 1))
            }
        }
        return -1
    }
}

class TestCase(val nums: IntArray, val x: Int)

fun main() {
    val solution = Solution()
    val testCases = arrayOf(TestCase(intArrayOf(1, 1, 4, 2, 3), 5),
            TestCase(intArrayOf(5, 6, 7, 8, 9), 4), TestCase(intArrayOf(3, 2, 20, 1, 1, 3), 10),
            TestCase(intArrayOf(5, 2, 3, 1, 1), 5))
    for (case in testCases) {
        println(solution.minOperations(case.nums, case.x))
    }
}