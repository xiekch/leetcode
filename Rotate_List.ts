/**
 * Definition for singly-linked list.
 * class ListNode {
 *     val: number
 *     next: ListNode | null
 *     constructor(val?: number, next?: ListNode | null) {
 *         this.val = (val===undefined ? 0 : val)
 *         this.next = (next===undefined ? null : next)
 *     }
 * }
 */
class ListNode {
    val: number
    next: ListNode | null
    constructor(val?: number, next?: ListNode | null) {
        this.val = (val === undefined ? 0 : val)
        this.next = (next === undefined ? null : next)
    }
}

function rotateRight(head: ListNode | null, k: number): ListNode | null {
    if (k == 0 || head == null) {
        return head
    }
    function getLength(head: ListNode | null) {
        if (head == null) {
            return 0
        }
        let length = 1
        while (head.next) {
            length++
            head = head.next
        }
        return length
    }
    let length = getLength(head)
    k = k % length
    if (k == 0) {
        return head
    }
    let stepsToNewHead = length - k - 1
    let node = head
    while (stepsToNewHead > 0) {
        node = node.next!
        stepsToNewHead--
    }
    let list2 = node.next
    node.next = null
    node = list2!
    while (node.next) {
        node = node.next
    }
    node.next = head
    return list2
};