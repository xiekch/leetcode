class Solution {
    fun maxProfit(prices: IntArray): Int {
        if (prices.size <= 1) {
            return 0
        }

        var lowPrice = prices[0]
        var highPrice = prices[0]
        var maxProfit = 0
        for (i in prices.indices) {
            if (prices[i] < lowPrice) {
                lowPrice = prices[i]
                highPrice = prices[i]
            } else if (prices[i] > highPrice) {
                highPrice = prices[i]
                maxProfit = max(maxProfit, highPrice - lowPrice)
            }
        }
        return maxProfit
    }
}

fun main() {
    val testCases = arrayOf(intArrayOf(7, 1, 5, 3, 6, 4), intArrayOf(7, 6, 4, 3, 1))
    val sol = Solution()
    for (testCase in testCases) {
        println(sol.maxProfit(testCase))
    }
}