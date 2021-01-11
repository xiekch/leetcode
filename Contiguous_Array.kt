import kotlin.math.max

class Solution {
    fun findMaxLength(nums: IntArray): Int {
        if (nums.size <= 1) return 0
        val minIndex = HashMap<Int, Int>()
        minIndex[0] = -1
        var count = if (nums[0] == 1) 1 else -1
        minIndex[count] = 0
        var longestLength = 0
        for (i in 1..nums.lastIndex) {
            count += if (nums[i] == 1) 1 else -1
            if (!minIndex.containsKey(count)) minIndex[count] = i
            else longestLength = max(longestLength, i - minIndex[count]!!)
        }
        return longestLength
    }
}

fun main() {
    val solution = Solution()
    val testCases = arrayOf(intArrayOf(1, 0), intArrayOf(1, 0, 1, 0, 1), intArrayOf(1, 1, 0, 1, 0, 1), intArrayOf(1, 1, 1, 1, 0))
    for (case in testCases) {
        println(solution.findMaxLength(case))
    }
}
