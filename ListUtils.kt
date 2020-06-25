// Example:
// var li = ListNode(5)
// var v = li.`val`
// Definition for singly-linked list.
class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

object ListUtils {
    fun buildList(nums: IntArray?): ListNode? {
        if (nums == null) return null
        val dummy = ListNode(0)
        var p = dummy
        for (i in nums) {
            p.next = ListNode(i)
            p = p.next!!
        }
        return dummy.next
    }

    fun printList(head: ListNode?) {
        var head = head
        while (head != null) {
            System.out.printf("%d ", head.`val`)
            head = head.next
        }
        println()
    }
}