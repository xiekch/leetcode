class Solution {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        nums.sort()
        val res = HashSet<List<Int>>()
        for (i in nums.indices) {
            for (j in i + 1..nums.lastIndex) {
                var sum = nums[i] + nums[j]
                var low = j + 1
                var high = nums.lastIndex
                while (low < high) {
                    var t = sum + nums[low] + nums[high]
                    if (t == target) {
                        res.add(listOf(nums[i], nums[j], nums[low], nums[high]))
                        low++
                    } else if (t < target) {
                        low++
                    } else if (t > target) {
                        high--
                    }
                }
            }
        }
        return res.toList()
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    val testset = arrayOf(intArrayOf(1, 0, -1, 0, -2, 2),
            intArrayOf(0, 1, 2, 1, 0),
            intArrayOf(-3, -2, -1, 0, 0, 1, 2, 3))
    val targets = intArrayOf(0, 2, 0)
    for (i in testset.indices) {
        println(solution.fourSum(testset[i], targets[i]))
    }
}