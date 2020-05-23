class Solution {
    fun majorityElement(nums: IntArray): Int {
        var count = 0
        var majority = nums[0]
        for (i in nums) {
            if (count == 0) {
                majority = i
                count = 1
            } else if (i == majority) {
                count++
            } else {
                count--
            }
        }
        return majority
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    val testset = arrayOf(
        intArrayOf(3, 2, 3),
        intArrayOf(2, 2, 1, 1, 1, 2, 2),
        intArrayOf(2, 1, 1, 1, 2)
    )
    for (nums in testset) {
        println(solution.majorityElement(nums))
    }
}