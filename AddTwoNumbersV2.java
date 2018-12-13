
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0, sum;
        ListNode l = null;
        ListNode head = null;

        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            sum = x + y + carry;
            if (sum > 9) {
                sum -= 10;
                carry = 1;
            } else
                carry = 0;
            
            if (l != null) {
                l.next = new ListNode(sum);
                l = l.next;
            } else
                l = new ListNode(sum);

            if (head == null)
                head = l;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }

        if (carry != 0) {
            l.next = new ListNode(carry);
        }

        return head;
    }

}

//can use head node
