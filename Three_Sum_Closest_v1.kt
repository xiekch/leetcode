import kotlin.math.absoluteValue

class Solution {
    private fun findClosetDiff(nums: IntArray, target: Int, low: Int): Int {
        var diff = Int.MAX_VALUE
        var high = nums.size - 1
        var low = low
//        println("$low $high")
        while (low <= high) {
            val middle = (low + high) / 2
            val num = nums[(low + high) / 2]
            if (num == target) {
                diff = 0
                break
            } else if (num > target) {
                if (num - target < diff.absoluteValue) {
                    diff = num - target
                }
                high = middle - 1
            } else {
                if (target - num < diff.absoluteValue) {
                    diff = num - target
                }
                low = middle + 1
            }
        }
        return diff
    }

    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()
        var diff = Int.MAX_VALUE
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                val t = findClosetDiff(nums, target - (nums[i] + nums[j]), j + 1)
                if (t.absoluteValue < diff.absoluteValue) {
//                    println("${nums[i]} ${nums[j]} $diff $t")
                    diff = t
                    if (diff == 0) break
                }
            }
        }
        return target + diff
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