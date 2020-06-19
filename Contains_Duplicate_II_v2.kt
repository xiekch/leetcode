import java.util.*

class Solution {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val map = HashMap<Int, Int>()
        for (i in nums.indices) {
            val last = map.getOrDefault(nums[i], -k - 1)
            if (i - last <= k) {
                return true
            }
            map[nums[i]] = i
        }

        return false
    }
}

fun main() {
    val solution = Solution()
    val testset = arrayOf(
            intArrayOf(1, 2, 3, 1),
            intArrayOf(1, 0, 1, 1),
            intArrayOf(1, 2, 3, 1, 2, 3)
    )
    val ks = arrayOf(3, 1, 2)
    for (i in testset.indices)
        println(solution.containsNearbyDuplicate(testset[i], ks[i]))
}