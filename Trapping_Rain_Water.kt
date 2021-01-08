import java.util.*

class Solution {
    fun trap(height: IntArray): Int {
        var ans = 0
        val st = Stack<Int>()
        for ((i, h) in height.withIndex()) {
            while (!st.empty() && h > height[st.peek()]) {
                val middle = st.pop()
                if (st.empty()) break
                ans += (Math.min(h, height[st.peek()]) - height[middle]) * (i - st.peek() - 1)
            }
            st.push(i)
        }
        return ans
    }
}

fun main() {
    val solution = Solution()
    val testCases = arrayOf(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1))
    for (case in testCases) {
        println(solution.trap(case))
    }
}