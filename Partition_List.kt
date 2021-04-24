
/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun partition(head: ListNode?, x: Int): ListNode? {
        if (head == null) return null
        val bigHead = ListNode(0)
        val smallHead = ListNode(0)
        var big = bigHead
        var small = smallHead
        var node = head
        while (node != null) {
            if (node.`val` < x) {
                small.next = node
                small = small.next!!
            } else {
                big.next = node
                big = big.next!!
            }
            node = node.next
        }
        big.next = null
        small.next = bigHead.next
        return smallHead.next
    }
}

fun main() {
    data class TestCase(val head: IntArray, val x: Int)

    val solution = Solution()   
    val testCases =
        arrayOf(
            TestCase(intArrayOf(1, 4, 3, 2, 5, 2), 3), TestCase(intArrayOf(2, 1), 2), TestCase(
                intArrayOf(2, 1, 1), 2
            )
        )
    for (case in testCases) {
        val head = ListUtils.buildList(case.head)
        ListUtils.printList(head)
        val res = solution.partition(head, case.x)
        ListUtils.printList(res)
    }
}