import kotlin.math.min

class Solution {
    fun jump(nums: IntArray): Int {
        if (nums.isEmpty() || nums.size == 1) return 0
        val minimumNumberOfJumps = IntArray(nums.size) { 0xffffff }
        minimumNumberOfJumps[0] = 0
        var longest = 0
        for ((i, j) in nums.withIndex()) {
            if (i + j <= longest) continue
            longest = i + j
            if (longest >= nums.lastIndex) return minimumNumberOfJumps[i] + 1
            for (k in 1..j) {
                if (i + k >= nums.size) break
                minimumNumberOfJumps[i + k] = min(minimumNumberOfJumps[i + k], minimumNumberOfJumps[i] + 1)
            }
        }
        return minimumNumberOfJumps.last()
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
