class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortWith(Comparator { o1, o2 -> o1[0] - o2[0] })
        val result = mutableListOf<IntArray>()
        for (interval in intervals) {
            if (result.isEmpty() || interval[0] > result.last()[1]) result.add(interval)
            else result.last()[1] = maxOf(result.last()[1], interval[1])
        }
        return result.toTypedArray()
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    val testCases = arrayOf(arrayOf(intArrayOf(1, 3), intArrayOf(2, 6), intArrayOf(8, 10), intArrayOf(15, 18)),
            arrayOf(intArrayOf(1, 4), intArrayOf(4, 5)))
    for (case in testCases)
        println(solution.merge(case).joinToString { it.joinToString(",") })
}