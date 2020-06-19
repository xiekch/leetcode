
import java.util.*

class Solution {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val map = HashMap<Int, ArrayList<Int>>()
        for (i in nums.indices) {
            val arr = map.getOrDefault(nums[i], ArrayList())
            arr.add(i)
            map[nums[i]] = arr
        }

        for (num in map.keys) {
            val arr = map.getOrDefault(num, ArrayList())
            for (i in 1 until arr.size) {
                if (arr[i] - arr[i - 1] <= k) {
                    return true
                }
            }
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