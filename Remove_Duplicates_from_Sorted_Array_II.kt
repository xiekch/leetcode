class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var prev = 0
        var count = 0
        for ((i, cur) in nums.withIndex()) {
            if (i > 0 && cur == nums[i - 1]) count++
            else count = 1
            if (count <= 2) {
                nums[prev] = cur
                prev++
            }
        }
        return prev
    }
}

fun main() {
    val solution = Solution()
    val testCases = arrayOf(intArrayOf(1, 1, 1, 2, 2, 3), intArrayOf(0, 0, 1, 1, 1, 1, 2, 3, 3), intArrayOf(1))
    for (case in testCases) {
        println(solution.removeDuplicates(case))
        println(case.joinToString(" "))
    }
}
