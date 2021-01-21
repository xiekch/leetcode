import kotlin.math.max
import kotlin.math.min

class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val result = ArrayList<IntArray>()
        var i = 0
        while (i < intervals.size && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i])
            i++
        }
        val insertInterval = newInterval.copyOf()
        while (i < intervals.size && intervals[i][0] <= newInterval[1]) {
            insertInterval[0] = min(insertInterval[0], intervals[i][0])
            insertInterval[1] = max(insertInterval[1], intervals[i][1])
            i++
        }
        result.add(insertInterval)
        while (i < intervals.size) {
            result.add(intervals[i])
            i++
        }
        return result.toTypedArray()
    }

}

class TestCase(val intervals: Array<IntArray>, val newInterval: IntArray)

fun main() {
    val solution = Solution()
    val testCases = arrayOf(TestCase(arrayOf(intArrayOf(1, 3), intArrayOf(6, 9)), intArrayOf(2, 5)),
        TestCase(arrayOf(intArrayOf(1, 2), intArrayOf(3, 10)), intArrayOf(12, 16)),
        TestCase(arrayOf(), intArrayOf(5, 7)),
        TestCase(arrayOf(intArrayOf(1, 5)), intArrayOf(2, 3)),
        TestCase(arrayOf(intArrayOf(1, 2), intArrayOf(3, 5), intArrayOf(6, 7), intArrayOf(8, 10), intArrayOf(12, 16)), intArrayOf(4, 8)))
    for (case in testCases) {
        println(solution.insert(case.intervals, case.newInterval).joinToString(" ") { it.joinToString(",") })
    }
}