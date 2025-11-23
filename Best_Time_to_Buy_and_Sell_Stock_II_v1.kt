class Solution {
    fun maxProfit(prices: IntArray): Int {
        if (prices.size <= 1) {
            return 0
        }

        var lowPrice = prices[0]
        var highPrice = prices[0]
        var sumProfit = 0
        for (i in 1 until prices.size) {
            if (prices[i] < prices[i - 1]) {
                sumProfit += highPrice - lowPrice
                lowPrice = prices[i]
                highPrice = prices[i]
            } else if (prices[i] > highPrice) {
                highPrice = prices[i]
            }
        }
        sumProfit += highPrice - lowPrice
        return sumProfit
    }
}

fun main() {
    val testCases = arrayOf(
        intArrayOf(7, 1, 5, 3, 6, 4),
        intArrayOf(7, 6, 4, 3, 1),
        intArrayOf(1, 2, 3, 4, 5)
    )
    val sol = Solution()
    for (testCase in testCases) {
        println(sol.maxProfit(testCase))
    }
}