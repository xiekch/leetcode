class Solution {
    fun getPermutation(n: Int, k: Int): String {
        val factorial = IntArray(n + 1)
        val nums = ArrayList<Int>()
        factorial[0] = 1
        for (i in 1..n) {
            factorial[i] = i * factorial[i - 1]
            nums.add(i)
        }
        var result = 0
        // When working with index, always work 0-based. When working with length, always work 1-based.
        var k = k - 1
        for (i in n - 1 downTo 0) {
            val index = k / factorial[i]
            result = result * 10 + nums[index]
            nums.removeAt(index)
            k %= factorial[i]
        }
        return result.toString()
    }
}

fun main() {
    val solution = Solution()
    val testCases = arrayOf(intArrayOf(3, 3), intArrayOf(4, 9), intArrayOf(3, 1))
    for (case in testCases) {
        println(solution.getPermutation(case[0], case[1]))
    }
}
