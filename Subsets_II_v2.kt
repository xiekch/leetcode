class Solution {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>()
        val count = HashMap<Int, Int>()
        for (num in nums) {
            count[num] = count[num]?.plus(1) ?: 1
        }
        result.add(mutableListOf())
        for ((num, times) in count) {
            val tempSet = mutableListOf<MutableList<Int>>()
            for (subset in result) {
                val t = subset.toMutableList()
                for (i in 1..times) {
                    t.add(num)
                    tempSet.add(t.toMutableList())
                }
            }
            result.addAll(tempSet)
        }
        return result
    }

}

fun main() {
    val solution = Solution()
    val testCases = arrayOf(intArrayOf(1, 2, 2), intArrayOf(0))
    for (case in testCases) {
        println(solution.subsetsWithDup(case))
    }
}