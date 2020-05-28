// Given a list of non-negative numbers and a target integer k, write a function to check if the array has a continuous subarray of size at least 2 that sums up to a multiple of k, that is, sums up to n*k where n is also an integer.
class Solution {
    fun checkSubarraySum(nums: IntArray, k: Int): Boolean {
        val map = HashMap<Int, Int>()
        var curSum = 0
        // for the case [0,0] 0
        map[0] = -1
        for (i in 0..nums.lastIndex) {
            curSum += nums[i]
            for (s in map.keys) {
                if (k == 0) {
                    if (curSum - s == 0 && i - (map[s] ?: i) > 1) {
                        return true
                    }
                } else if ((curSum - s) % k == 0 && i - (map[s] ?: i) > 1) {
                    return true
                }
            }
            map[curSum] = map[curSum] ?: i
        }
        return false
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    val testset = arrayOf(
        intArrayOf(23, 2, 4, 6, 7),
        intArrayOf(23, 2, 6, 4, 7),
        intArrayOf(2, 1, 1, 1, 2),
        intArrayOf(5, 2, 4),
        intArrayOf(23, 2, 6, 4, 7),
        intArrayOf(1, 0, 0),
        intArrayOf(0, 1, 0),
        intArrayOf(0, 0),
        intArrayOf(0, 0),
        intArrayOf(1, 5),
        intArrayOf(0)
    )
    val ks = intArrayOf(6, 6, 1, 5, 0, 0, 0, 0, 100, -6, 0)
    for (i in 0..testset.lastIndex) {
        println(solution.checkSubarraySum(testset[i], ks[i]))
    }
}