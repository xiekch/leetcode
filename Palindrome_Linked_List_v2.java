
// Definition for singly-linked list.
// class ListNode {
//     int val;
//     ListNode next;

//     ListNode() {
//     }

//     ListNode(int val) {
//         this.val = val;
//     }

//     ListNode(int val, ListNode next) {
//         this.val = val;
//         this.next = next;
//     }
// }

// do it in O(n) time and O(1) space
class Solution {
    private ListNode reverseList(ListNode head) {
        ListNode prev = null, temp;

        while (head != null) {
            temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;

        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (slow.next != null)
            slow = slow.next;
        fast = reverseList(slow);
        slow = head;
        // ListUtils.printList(slow);
        // ListUtils.printList(fast);
        while (slow != null && fast != null) {
            if (slow.val != fast.val)
                return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
}

public class Palindrome_Linked_List_v2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] testset = { { 1 }, { 1, 2, 2, 1 }, { 1, 2, 3, 2, 1 }, { -129, -129 }, { 1, 2 }, { -129, -129, 1 } };
        for (int[] nums : testset) {
            ListNode head = ListUtils.buildList(nums);
            System.out.println(solution.isPalindrome(head));
        }
    }
}