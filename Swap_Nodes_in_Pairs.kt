import java.util.Stack


/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
//Given 1->2->3->4, you should return the list as 2->1->4->3.
//class ListNode(var `val`: Int) {
//    var next: ListNode? = null
//}

class Solution {
    fun swapPairs(head: ListNode?): ListNode? {
        val dummy = ListNode(0)
        dummy.next = head
        var pre: ListNode? = dummy
        var node = head
        val st = Stack<ListNode>()
        while (node != null) {
            for (i in 1..2)
                if (node != null) {
                    st.push(node)
                    node = node.next
                }
            for (i in 1..2) {
                pre?.next = if (st.empty()) null else st.pop()
//                println(pre?.next?.`val`)
                pre = pre?.next
            }
            pre?.next = null
        }
        return dummy.next
    }
}

fun main() {
    val testset = intArrayOf(1, 2, 3, 4, 5)
    val head = ListUtils.buildList(testset)
    val solution = Solution()
    ListUtils.printList(solution.swapPairs(head))
}

