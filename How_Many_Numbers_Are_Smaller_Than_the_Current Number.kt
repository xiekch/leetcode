
class Solution {
    data class Node(
        val num: Int,
        var count: Int = 0,
        var left: Node? = null,
        var right: Node? = null
    )

    fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
        val res = IntArray(nums.size)
        if (nums.isEmpty()) return res
        val root = Node(nums[0])
        for (n in nums) {
            var node: Node = root
            while (true) {
                if (node.num == n) {
                    node.count++
                    break
                } else if (node.num > n) {
                    node.count++
                    val t = node.left
                    if (t != null) node = t
                    else {
                        node.left = Node(n, 1)
                        node.left?.let { node = it }
                        break
                    }
                } else {
                    val t = node.right
                    if (t != null) node = t
                    else {
                        node.right = Node(n, 1)
                        node.right?.let { node = it }
                        break
                    }
                }
            }
        }
        for ((i, n) in nums.withIndex()) {
            var node: Node = root
            var sum = 0
            while (true) {
//                print("${node.num}:${node.count} ")
                if (node.num >= n) {
                    val t = node.left
                    if (t != null) node = t
                    else break
                } else {
                    sum += node.count
                    val t = node.right
                    if (t != null) node = t
                    else break
                }
            }
//            println()
            res[i] = sum
        }
        return res
    }
}

fun main() {
    val solution = Solution()
    val testCases =
        arrayOf(intArrayOf(8, 1, 2, 2, 3), intArrayOf(6, 5, 4, 8), intArrayOf(7, 7, 7, 7))
    for (case in testCases) {
        println(solution.smallerNumbersThanCurrent(case).joinToString())
    }
}