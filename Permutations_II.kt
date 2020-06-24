class Solution {
    private val res = ArrayList<List<Int>>()

    fun dfs(nums: IntArray, num: ArrayList<Int>, visited: BooleanArray) {
        if (num.size == nums.size) {
            res.add(ArrayList<Int>(num))
            return
        }
        for (i in nums.indices) {
            if (!visited[i]) {
                // !visited is the same with visited
                if (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1])
                    continue
                visited[i] = true
                num.add(nums[i])
                dfs(nums, num, visited)
                num.removeAt(num.size - 1)
                visited[i] = false
            }
        }
    }

    fun permuteUnique(nums: IntArray): List<List<Int>> {
        res.clear()
        nums.sort()
        dfs(nums, ArrayList(), BooleanArray(nums.size) { false })
        return res.toList()
    }
}

fun main() {
    val solution = Solution()
    val testset = arrayOf(intArrayOf(1, 1, 2),
            intArrayOf(2, 2, 1, 1)
    )
    for (nums in testset)
        solution.permuteUnique(nums).forEach { println(it) }
}