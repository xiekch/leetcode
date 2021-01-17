class Solution {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        return partition(nums, nums.size - k, 0, nums.size - 1)
    }

    private fun partition(nums: IntArray, k: Int, left: Int, right: Int): Int {
        if (right == left) return nums[left]
        val pivot = nums[left]
        var start = left
        var end = right
        while (start < end) {
            while (nums[end] >= pivot && start < end) end--
            nums[start] = nums[end]
            while (nums[start] < pivot && start < end) start++
            nums[end] = nums[start]
        }
        nums[start] = pivot
        // println(nums.joinToString(" "))
        // println("$k $start $left $right")
        return when {
            start == k -> nums[start]
            start < k -> partition(nums, k, start + 1, right)
            else -> partition(nums, k, left, start)
        }
    }
}

class TestCase(val nums: IntArray, val k: Int)

fun main() {
    val solution = Solution()
    val testCases = arrayOf(TestCase(intArrayOf(3, 2, 1, 5, 6, 4), 2),
            TestCase(intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6), 4),
            TestCase(intArrayOf(1, 2, 3, 4, 5, 6), 1))
    for (case in testCases) {
        println(solution.findKthLargest(case.nums, case.k))
    }
}