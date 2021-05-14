class Solution {
    fun reachingPoints(sx: Int, sy: Int, tx: Int, ty: Int): Boolean {
        var tx = tx
        var ty = ty
        while (tx > sx && ty > sy) {
            if (tx > ty) tx %= ty
            else ty %= tx
        }
        return (tx == sx && sy <= ty && (ty - sy) % sx == 0) || (ty == sy && sx <= tx && (tx - sx) % sy == 0)
    }
}

fun main() {
    val solution = Solution()
    val testCases = arrayOf(
        intArrayOf(1, 1, 2, 2),
        intArrayOf(1, 1, 1, 1),
        intArrayOf(3, 3, 12, 9),
        intArrayOf(9, 5, 12, 8),
        intArrayOf(9, 10, 9, 19)
    )
    for (testCase in testCases) {
        println(solution.reachingPoints(testCase[0], testCase[1], testCase[2], testCase[3]))
    }
}