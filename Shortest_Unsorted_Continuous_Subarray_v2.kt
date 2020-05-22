import java.util.*

// https://leetcode.com/problems/shortest-unsorted-continuous-subarray/solution/#approach-4-using-stack
// We need to determine the correct position of the minimum and the maximum element
//  in the unsorted subarray to determine the boundaries of the required unsorted subarray.

class Solution {
    fun findUnsortedSubarray(nums: IntArray): Int {
        if (nums.isEmpty())
            return 0

        val st = Stack<Int>()
        var right = -1
        var left = nums.size
        for (i in nums.indices) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                left = Math.min(left, st.pop())
            }
            st.push(i)
        }
//        println("left " + left)
        st.clear()
        for (i in nums.size - 1 downTo 0) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                right = Math.max(right, st.pop())
            }
            st.push(i)
        }
//        println("right " + right)
        return if (right - left + 1 > 0) right - left + 1 else 0
    }
}


fun main(args: Array<String>) {
    val solution = Solution()

    val testset = arrayOf(
        intArrayOf(),
        intArrayOf(1),
        intArrayOf(1, 2),
        intArrayOf(2, 1),
        intArrayOf(2, 6, 4, 8, 10, 9, 15),
        intArrayOf(10, 8, 10, 9, 15, 7),
        intArrayOf(2, 1, 10, 0, 3)
    );
    for (nums in testset) {
        println(solution.findUnsortedSubarray(nums))
    }
}