import java.lang.Integer.max

class Solution {
    fun jump(nums: IntArray): Int {
        if (nums.isEmpty() || nums.size == 1) return 0
        var step = 0
        var cur = 0
        var longest = 0
        while (longest < nums.lastIndex) {
            step++
            val temp = longest
            for (i in cur..longest) {
                longest = max(longest, i + nums[i])
                if (longest >= nums.lastIndex) break
            }
            cur = temp
        }
        return step
    }
}

fun main() {
    val solution = Solution()
    // 2 2 0 2
    val testCases = arrayOf(intArrayOf(2, 3, 1, 1, 4), intArrayOf(2, 3, 0, 1, 4), intArrayOf(1), intArrayOf(7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3))
    for (case in testCases) {
        println(solution.jump(case))
    }
}
