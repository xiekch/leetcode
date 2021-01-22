import java.util.*

class Solution {
    fun mostCompetitive(nums: IntArray, k: Int): IntArray {
        val st = Stack<Int>()
        val result = IntArray(k)
        for (i in nums.indices) {
            while (!st.empty() && nums[i] < st.peek() && nums.size - i + st.size > k) st.pop()
            if (st.size < k) st.push(nums[i])
        }
        for (i in k - 1 downTo 0) {
            result[i] = st.pop()
        }
        return result
    }
}

class TestCase(val nums: IntArray, val k: Int)

fun main() {
    val solution = Solution()
    val testCases = arrayOf(TestCase(intArrayOf(3, 5, 2, 6), 2), TestCase(intArrayOf(2, 4, 3, 3, 5, 4, 9, 6), 4))
    for (case in testCases) {
        println(solution.mostCompetitive(case.nums, case.k).joinToString(" "))
    }
}