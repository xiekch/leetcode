class Solution {
    fun numRescueBoats(people: IntArray, limit: Int): Int {
        people.sort()
        var left = 0
        var right = people.size - 1
        var result = 0
        while (right >= left) {
            var sum = 0
            var count = 0
            while (right >= left && sum + people[right] <= limit && count < 2) {
                sum += people[right]
                right--
                count++
            }
            while (right >= left && sum + people[left] <= limit && count < 2) {
                sum += people[left]
                left++
                count++
            }
            result++
        }
        return result
    }
}

class TestCase(val people: IntArray, val limit: Int)

fun main() {
    val solution = Solution()
    val testCases = arrayOf(TestCase(intArrayOf(1, 2), 3), TestCase(intArrayOf(1, 1, 1, 2, 2, 2), 3),
            TestCase(intArrayOf(3, 2, 2, 1), 3), TestCase(intArrayOf(3, 5, 3, 4), 5),
            TestCase(intArrayOf(3, 2, 3, 2, 2), 6))
    for (case in testCases) {
        println(solution.numRescueBoats(case.people, case.limit))
    }
}
