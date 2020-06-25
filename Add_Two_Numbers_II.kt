import java.util.*
// https://leetcode.com/problems/add-two-numbers-ii/discuss/92623/Easy-O(n)-Java-Solution-using-Stackhttps://leetcode.com/problems/add-two-numbers-ii/discuss/92623/Easy-O(n)-Java-Solution-using-Stack
//  Definition for singly-linked list.

// Example:
// var li = ListNode(5)
// var v = li.`val`
// Definition for singly-linked list.
//class ListNode(var `val`: Int) {
//    var next: ListNode? = null
//}

class Solution {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var p1 = l1
        var p2 = l2
        val st1 = Stack<Int>();
        val st2 = Stack<Int>()
        while (p1 != null) {
            st1.push(p1.`val`)
            p1 = p1.next
        }

        while (p2 != null) {
            st2.push(p2.`val`)
            p2 = p2.next
        }

        var carry = 0
        var head: ListNode? = null
        while (!st1.isEmpty() || !st2.isEmpty() || carry == 1) {
            val sum = (if (st1.isEmpty()) 0 else st1.pop()) + (if (st2.isEmpty()) 0 else st2.pop()) + carry
            val t = ListNode(sum % 10)
//            println("%d %d".format(sum, t.`val`))
            t.next = head
            head = t
            carry = sum / 10
        }
        return head
    }
}

fun main() {
    val solution = Solution()
    val testset = arrayOf(
            arrayOf(
                    intArrayOf(7, 2, 4, 3),
                    intArrayOf(5, 6, 4)
            ),
            arrayOf(
                    intArrayOf(5),
                    intArrayOf(5)
            )
    )
    for (test in testset) {
        val l1 = ListUtils.buildList(test[0])
        val l2 = ListUtils.buildList(test[1])
        ListUtils.printList(solution.addTwoNumbers(l1, l2))
    }
}