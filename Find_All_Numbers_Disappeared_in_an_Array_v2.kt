// Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array),
// Find all the elements of [1, n] inclusive that do not appear in this array.
class Solution {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val res = ArrayList<Int>()
        for (i in nums) {
            var index = Math.abs(i) - 1
            if (nums[index] > 0)
                nums[index] = -nums[index]
        }

        for (i in 0..nums.lastIndex) {
            if (nums[i] > 0) {
                res.add(i + 1)
            }
        }
        return res
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    val testset = arrayOf(
        intArrayOf(4, 3, 2, 7, 8, 2, 3, 1),
        intArrayOf(3, 3, 2)
    )
    for (nums in testset) {
        val res = solution.findDisappearedNumbers(nums)
        for (i in res) {
            print(i)
            print(" ")
        }
        println()
    }
}