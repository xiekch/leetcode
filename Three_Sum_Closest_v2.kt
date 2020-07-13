import kotlin.math.absoluteValue

//https://leetcode.com/problems/3sum-closest/solution/
// two points
class Solution {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()
        var diff = Int.MAX_VALUE
        for (i in nums.indices) {
            var low = i + 1
            var high = nums.lastIndex
            while (low < high) {
                val sum = nums[i] + nums[low] + nums[high]
                if ((target - sum).absoluteValue < diff.absoluteValue) {
                    diff = target - sum
                }
                if (sum < target) {
                    low++
                } else if (sum > target) {
                    high--
                } else break
            }
            if (diff == 0) break
        }
        return target - diff
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    val testset = arrayOf(intArrayOf(-1, 2, 1, -4),//2
            intArrayOf(0, 1, 2),//3
            intArrayOf(1, -3, 3, 5, 4, 1))//1
    val targets = intArrayOf(1, 3, 1)
    for (i in testset.indices) {
        println(solution.threeSumClosest(testset[i], targets[i]))
    }
}