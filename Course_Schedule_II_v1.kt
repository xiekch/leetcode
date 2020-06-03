// Given the total number of courses and a list of prerequisite pairs,
//  return the ordering of courses you should take to finish all courses.
class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val res = ArrayList<Int>()
        val indegree = IntArray(numCourses)
        val edges = ArrayList<ArrayList<Int>>()
        for (i in 1..numCourses) {
            edges.add(ArrayList())
        }
//        println(edges.size)
        for (pre in prerequisites) {
            edges[pre[1]].add(pre[0])
            indegree[pre[0]]++
        }

        var finished = false
        while (!finished) {
            finished = true
            for (i in 0 until numCourses) {
                if (indegree[i] == 0) {
                    res.add(i)
                    finished = false
                    for (e in edges[i]) {
                        indegree[e]--
                    }
                    indegree[i] = -1
                    break
                }
            }
        }

        return if (res.size == numCourses) res.toIntArray() else IntArray(0)
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    val testset = arrayOf(
        arrayOf(
            intArrayOf(1, 0)
        ),
        arrayOf(
            intArrayOf(1, 0),
            intArrayOf(2, 0),
            intArrayOf(3, 1),
            intArrayOf(3, 2)
        ),
        arrayOf(
            intArrayOf(1, 0),
            intArrayOf(0, 1)
        )
    )
    val nums = intArrayOf(2, 4, 2)
    for (i in testset.indices) {
        solution.findOrder(nums[i], testset[i]).forEach { print("%d ".format(it)) }
        println()
    }
}