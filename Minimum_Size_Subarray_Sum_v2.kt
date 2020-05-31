// Given an array of n positive integers and a positive integer s, find the minimal
//  length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
// two points
class Solution {
    fun minSubArrayLen(s: Int, nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        var res = Int.MAX_VALUE
        var left = 0
        var sum = 0
        for (i in nums.indices) {
            sum += nums[i]
            while (sum >= s) {
                res = Math.min(res, i - left + 1)
                sum -= nums[left]
                left++
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
