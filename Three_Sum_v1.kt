
class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val result = mutableListOf<List<Int>>()
        for (i in nums.indices) {
            var left = i + 1;
            var right = nums.lastIndex
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue
            }
            while (left < right) {
                val sum = nums[left] + nums[right] + nums[i]
                if (sum == 0) {
                    result.add(listOf(nums[i], nums[left], nums[right]))
                    left++
                    right--
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++
                    }
                } else if (sum < 0) {
                    left++
                } else {
                    right--
                }
            }
        }
        return result
    }
}


fun main() {
    val testCases =
        listOf<IntArray>(
            intArrayOf(0, 1, 1),
            intArrayOf(-1, 0, 1, 2, -1, -4),
            intArrayOf(0, 0, 0),
            intArrayOf(2, -3, 0, -2, -5, -5, -4, 1, 2, -2, 2, 0, 2, -4, 5, 5, -10)
        )
    val sol = Solution()
    for (testCase in testCases) {
        println(sol.threeSum(testCase))
    }
}
