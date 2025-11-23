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
    fun reverseList(head: ListNode?): ListNode? {
        head ?: return null
        var node = head
        var prev: ListNode? = null
        var next: ListNode? = null
        while (node != null) {
            next = node.next
            node?.next = prev
            prev = node
            node = next
        }
        return prev
    }
}