class Solution {
    fun reachingPoints(sx: Int, sy: Int, tx: Int, ty: Int): Boolean {
//        println("$tx,$ty")
        if (tx == sx && ty == sy) return true
        if (tx <= 0 || ty <= 0) return tx == sx && ty == sy
        if (tx < sx || ty < sy) return false
        return if (tx > ty) {
            reachingPoints(sx, sy, tx - maxOf((tx - sx) / ty, 1) * ty, ty)
        } else if (tx < ty) {
            reachingPoints(sx, sy, tx, ty - maxOf((ty - sy) / tx, 1) * tx)
        } else
            sx == 0 && sy == 0
    }
}

fun main() {
    val solution = Solution()
    val testCases = arrayOf(
        intArrayOf(1, 1, 2, 2),
        intArrayOf(1, 1, 1, 1),
        intArrayOf(3, 3, 12, 9),
        intArrayOf(0, 0, 3, 3),
        intArrayOf(9, 5, 12, 8),
        intArrayOf(9, 10, 9, 19)
    )
    for (testCase in testCases) {
        println(solution.reachingPoints(testCase[0], testCase[1], testCase[2], testCase[3]))
    }
}