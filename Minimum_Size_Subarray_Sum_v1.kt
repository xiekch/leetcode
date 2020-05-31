// Given an array of n positive integers and a positive integer s, find the minimal
//  length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
class Solution {
    fun minSubArrayLen(s: Int, nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        val preSum = IntArray(nums.size)
        preSum[0] = nums[0]
        for (i in 1..preSum.lastIndex) {
            preSum[i] = preSum[i - 1] + nums[i]
        }
        var res = Int.MAX_VALUE
        for (i in nums.indices) {
            for (j in i..nums.lastIndex) {
                if (preSum[j] - preSum[i] + nums[i] >= s) {
                    res = Math.min(j-i + 1, res)
                    break
                }
            }
        }

        return if (res == Int.MAX_VALUE) 0 else res
    }
}

fun main() {
    val solution = Solution()
    val testset = arrayOf(
        intArrayOf(2, 3, 1, 2, 4, 3),
        intArrayOf(2, 3, 1, 2, 4, 3),
        intArrayOf(2, 3, 1, 2, 4, 3),
        intArrayOf(1, 2, 3, 4, 5)
    )
    val ss = intArrayOf(7, 8, 11, 11)
    for (i in testset.indices) {
        println(solution.minSubArrayLen(ss[i], testset[i]))
    }
}