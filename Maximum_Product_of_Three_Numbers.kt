import kotlin.math.max

class Solution {
    fun maximumProduct(nums: IntArray): Int {
        nums.sort()
        val n = nums.size
        if (nums.last() <= 0 || nums[0] >= 0) return nums[n - 1] * nums[n - 2] * nums[n - 3]
        return max(nums[n - 1] * nums[n - 2] * nums[n - 3], nums[0] * nums[1] * nums[n - 1])
    }
}

fun main() {
    val solution = Solution()
    val testCases = arrayOf(intArrayOf(1, 2, 3), intArrayOf(1, 2, 3, 4), intArrayOf(-1, -2, -3), intArrayOf(-1, -2, -3, 3))
    for (case in testCases) {
        println(solution.maximumProduct(case))
    }
}