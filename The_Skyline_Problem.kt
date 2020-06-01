import java.util.*
import kotlin.collections.ArrayList

//https://leetcode.com/problems/the-skyline-problem/discuss/61193/Short-Java-solution
class Solution {
    fun getSkyline(buildings: Array<IntArray>): List<List<Int>> {
        val res = ArrayList<ArrayList<Int>>()
        val height = ArrayList<ArrayList<Int>>()
        for (building in buildings) {
            height.add(arrayListOf(building[0], building[2]))
            height.add(arrayListOf(building[1], -building[2]))
        }
        height.sortWith(Comparator { a, b -> if (a[0] == b[0]) a[1] - b[1] else a[0] - b[0] })
//        println(height)
        val pq = PriorityQueue<Int>(Comparator { a, b -> b - a })
        pq.offer(0)
        var prevHeight = 0
        for (point in height) {
//            println(point)
            if (point[1] > 0) {
                pq.offer(point[1])
            } else {
                pq.remove(-point[1])
            }
            if (!pq.isEmpty() && pq.peek() != prevHeight) {
                res.add(arrayListOf(point[0], pq.peek()))
//                println(res)
                prevHeight = pq.peek()
            }
        }

        return res
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    val testset = arrayOf(
        arrayOf(
            intArrayOf(2, 9, 10),
            intArrayOf(3, 7, 15),
            intArrayOf(5, 12, 12),
            intArrayOf(15, 20, 10),
            intArrayOf(19, 24, 8)
        ),
        arrayOf(
            intArrayOf(0, 2, 3),
            intArrayOf(2, 5, 3)
        )
    )
    for (buildings in testset)
        println(solution.getSkyline(buildings))
}