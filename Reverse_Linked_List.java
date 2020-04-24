// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode top = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return top;
    }
}

public class Reverse_Linked_List {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        a.next = b;
        b.next = c;

        Solution sol = new Solution();
        ListNode ans = sol.reverseList(a);
        while (ans != null) {
            System.out.println(ans.val);
            ans = ans.next;
        }
    }
}