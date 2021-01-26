class Solution {
    fun kLengthApart(nums: IntArray, k: Int): Boolean {
        var lastOne = -k - 1
        for (i in nums.indices) {
            if (nums[i] == 1) {
                if (i - lastOne <= k) return false
                lastOne = i
            }
        }
        return true
    }
}

class TestCase(val nums: IntArray, val k: Int)

fun main() {
    val solution = Solution()
    val testCases = arrayOf(
        TestCase(intArrayOf(1, 0, 0, 0, 1, 0, 0, 1), 2),
        TestCase(intArrayOf(1, 0, 0, 1, 0, 1), 2),
        TestCase(intArrayOf(1, 1, 1, 1), 0),
        TestCase(intArrayOf(0, 1, 0, 1), 1),
        TestCase(intArrayOf(0, 1, 0, 1, 1), 1))

    for (case in testCases) {
        println(solution.kLengthApart(case.nums, case.k))
    }
}