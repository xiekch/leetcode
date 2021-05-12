class Solution {
    fun isPossible(target: IntArray): Boolean {
        var s = 0L
        target.forEach { s += it }
        val pq = PriorityQueue<Int>(Collections.reverseOrder())
        pq.addAll(target.toTypedArray())
        while (s > 1 && pq.peek() > s / 2) {
            val cur = pq.poll() ?: break
            s -= cur
            if (s == 0L) return false
            if (s == 1L) return true
            pq.add(cur % s.toInt())
            s += cur % s
        }
        return s == target.size.toLong()
    }
}

fun main() {
    val solution = Solution()
    val testCases = arrayOf(
        intArrayOf(9, 3, 5),
        intArrayOf(1, 1, 1, 2),
        intArrayOf(8, 5),
        intArrayOf(1, 3),
        intArrayOf(30)
    )
    for (testCase in testCases) {
        println(solution.isPossible(testCase))
    }
}