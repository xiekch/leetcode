
class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        if (matrix.isEmpty()) {
            return false
        }
        val firstRow = matrix[0]
        val m = matrix.size
        val n = firstRow.size
        var low = 0
        var high = m - 1
        while (low <= high) {
            val mid = (low + high) / 2
            if (matrix[mid][0] > target) {
                high = mid - 1
            } else if (matrix[mid][0] < target) {
                low = mid + 1
            } else {
                return true
            }
        }

        if (high < 0) {
            return false
        }
        // high 指向最后一个满足 matrix[high][0] <= target 的行
        val index = high
        low = 0
        high = n - 1
        while (low <= high) {
            val mid = (low + high) / 2
            if (matrix[index][mid] > target) {
                high = mid - 1
            } else if (matrix[index][mid] < target) {
                low = mid + 1
            } else {
                return true
            }
        }
        return false
    }
}


fun main() {
    val testCase =
        arrayOf<IntArray>(
            intArrayOf(1, 3, 5, 7),
            intArrayOf(10, 11, 16, 20),
            intArrayOf(23, 30, 34, 60)
        )
    val sol = Solution()
    println(sol.searchMatrix(testCase, 11))
    println(sol.searchMatrix(testCase, 3))
    println(sol.searchMatrix(testCase, 12))
}