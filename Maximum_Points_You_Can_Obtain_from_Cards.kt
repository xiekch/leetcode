class Solution {
    fun maxScore(cardPoints: IntArray, k: Int): Int {
        var cur = 0
        val n = cardPoints.size
        for (i in 0 until k) {
            cur += cardPoints[i]
        }
        if (k == n) return cur
        var res = cur
        for (i in 0 until k) {
            cur += cardPoints[n - i - 1]
            cur -= cardPoints[k - i - 1]
            res = maxOf(res, cur)
        }
        return res
    }
}

fun main() {
    class TestCase(val cardPoints: IntArray, val k: Int)

    val solution = Solution()
    val testCases = arrayOf(
        TestCase(intArrayOf(1, 2, 3, 4, 5, 6, 1), 3),
        TestCase(intArrayOf(2, 2, 2), 2),
        TestCase(intArrayOf(9, 7, 7, 9, 7, 7, 9), 7),
        TestCase(intArrayOf(1, 79, 80, 1, 1, 1, 200, 1), 3),
        TestCase(intArrayOf(96, 90, 41, 82, 39, 74, 64, 50, 30), 8)
    )
    for (testCase in testCases) {
        println(solution.maxScore(testCase.cardPoints, testCase.k))
    }
}