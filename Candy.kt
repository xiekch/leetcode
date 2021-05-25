// greedy method
class Solution {
    fun candy(ratings: IntArray): Int {
        if (ratings.isEmpty()) return 0
        val n = ratings.size
        val amount = IntArray(n)
        amount[0] = 1
        for (i in 1 until n) {
            if (ratings[i] > ratings[i - 1]) {
                amount[i] = amount[i - 1] + 1
            } else amount[i] = 1
        }
        var res = amount[n - 1]
        for (i in n - 2 downTo 0) {
            if (ratings[i] > ratings[i + 1]) {
                amount[i] = maxOf(amount[i + 1] + 1, amount[i])
            }
            res += amount[i]
        }
        // println(amount.joinToString(" "))
        return res
    }
}

fun main() {
    val solution = Solution()
    val testCases = arrayOf(
        intArrayOf(1, 0, 2),
        intArrayOf(1, 2, 2),
        intArrayOf(1, 2, 3),
        intArrayOf(3, 2, 1),
        intArrayOf(1, 3, 4, 5, 2)
    )

    for (testCase in testCases) {
        println(solution.candy(testCase))
    }
}
