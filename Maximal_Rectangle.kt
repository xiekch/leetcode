import kotlin.math.max
import kotlin.math.min

/**
 * height[i] record the current number of countinous '1' in column i;
 * left[i] record the left most index j which satisfies that for any index k from j to  i, height[k] >= height[i];
 * right[i] record the right most index j which satifies that for any index k from i to  j, height[k] >= height[i];
 */
class Solution {
    fun maximalRectangle(matrix: Array<CharArray>): Int {
        if (matrix.isEmpty() || matrix[0].isEmpty()) return 0
        val m = matrix.size
        val n = matrix[0].size
        // we know initially, height array contains all 0, so according to the definition of left and right array,
        // left array should contains all 0, and right array should contain all n - 1
        val height = IntArray(n)
        val right = IntArray(n) { n }
        val left = IntArray(n)
        var result = 0
        for (i in 0 until m) {
            for (j in 0 until n) {
                height[j] = if (matrix[i][j] == '1') height[j] + 1 else 0
            }
            var leftBound = 0
            for (j in 0 until n) {
                // this means the current bound should satisfy two conditions:
                // within the boundry of the previous height array, and within the boundry of the current row...
                if (matrix[i][j] == '1') left[j] = max(left[j], leftBound)
                else {
                    // since all height in between 0 - j satisfies the condition of height[k] >= height[j];
                    left[j] = 0
                    leftBound = j + 1
                }
            }
            var rightBound = n
            for (j in n - 1 downTo 0) {
                if (matrix[i][j] == '1') right[j] = min(right[j], rightBound)
                else {
                    right[j] = n
                    rightBound = j
                }
            }
            for (j in 0 until n) {
                result = max(result, (right[j] - left[j]) * height[j])
            }
//            println(i)
//            println(height.joinToString(" "))
//            println(left.joinToString(" "))
//            println(right.joinToString(" "))
        }

        return result
    }
}

fun main() {
    val solution = Solution()
    val testCases = arrayOf(arrayOf(
        charArrayOf('1', '0', '1', '0', '0'),
        charArrayOf('1', '0', '1', '1', '1'),
        charArrayOf('1', '1', '1', '1', '1'),
        charArrayOf('1', '0', '0', '1', '0')),
        arrayOf(charArrayOf()), arrayOf(charArrayOf('0')), arrayOf(charArrayOf('1')),
        arrayOf(charArrayOf('0', '1', '0'), charArrayOf('1', '1', '1')),
        arrayOf(charArrayOf('1', '0', '0', '0', '0', '1', '0', '1', '1', '0'),
            charArrayOf('0', '1', '1', '1', '1', '1', '1', '0', '1', '0'),
            charArrayOf('0', '0', '1', '1', '1', '1', '1', '1', '1', '0')))
    for (case in testCases) {
        println(solution.maximalRectangle(case))
//        println()
    }
}