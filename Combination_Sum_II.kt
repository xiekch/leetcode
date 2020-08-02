class Solution {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        candidates.sort()
        val res = ArrayList<MutableList<Int>>()
        combinationSum(candidates, target, res, 0, mutableListOf())
        return res
    }

    private fun combinationSum(candidates: IntArray, target: Int, res: ArrayList<MutableList<Int>>, cur: Int, path: MutableList<Int>) {
//        println("$path,$target")
        if (target < 0) return
        if (0 == target) {
            res.add(path.toMutableList())
            return
        }

        for (i in cur..candidates.lastIndex) {
            if (i > cur && candidates[i] == candidates[i - 1]) continue
            path.add(candidates[i])
            combinationSum(candidates, target - candidates[i], res, i + 1, path)
            path.removeAt(path.lastIndex)
        }
    }
}


fun main() {
    val solution = Solution()
    val testset = arrayOf(
            intArrayOf(10, 1, 2, 7, 6, 1, 5),
            intArrayOf(2, 5, 2, 1, 2)
    )
    val targets = intArrayOf(8, 5)
    for (i in testset.indices) {
        println(solution.combinationSum2(testset[i], targets[i]))
    }
}