// Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array),
// Find all the elements of [1, n] inclusive that do not appear in this array.
class Solution {
    fun findDisappearedNumbers(nums: IntArray): List<Int> {
        val res = ArrayList<Int>()
        val marked = BooleanArray(nums.size + 1)
        for (i in nums) {
            marked[i] = true
        }

        for (i in 1..marked.lastIndex) {
            if (marked[i] == false) {
                res.add(i)
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