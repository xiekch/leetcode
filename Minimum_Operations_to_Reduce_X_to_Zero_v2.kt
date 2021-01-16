import kotlin.math.max

// [[Java] Detailed Explanation - O(N) Prefix Sum/Map - Longest Target Sub-Array](https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/discuss/935935/Java-Detailed-Explanation-O(N)-Prefix-SumMap-Longest-Target-Sub-Array )
class Solution {
    fun minOperations(nums: IntArray, x: Int): Int {
        var prefixSum = 0
        val map = HashMap<Int, Int>()
        map[0] = -1
        var maxLength = -1
        val target = nums.sum() - x
        for (i in nums.indices) {
            prefixSum += nums[i]
            map[prefixSum] = i
            if (map.containsKey(prefixSum - target)) {
                maxLength = max(maxLength, i - map[prefixSum - target]!!)
            }
        }
        return if (maxLength == -1) -1 else nums.size - maxLength
    }
}

class TestCase(val nums: IntArray, val x: Int)

fun main() {
    val solution = Solution()
    val testCases = arrayOf(TestCase(intArrayOf(1, 1, 4, 2, 3), 5),
            TestCase(intArrayOf(5, 6, 7, 8, 9), 4), TestCase(intArrayOf(3, 2, 20, 1, 1, 3), 10),
            TestCase(intArrayOf(5, 2, 3, 1, 1), 5),
            TestCase(intArrayOf(8828, 9581, 49, 9818, 9974, 9869, 9991, 10000, 10000, 10000, 9999, 9993, 9904, 8819, 1231, 6309),
                    134365))
    for (case in testCases) {
        println(solution.minOperations(case.nums, case.x))
    }
}