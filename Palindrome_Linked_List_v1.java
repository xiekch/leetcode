import java.util.ArrayList;

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
    public boolean isPalindrome(ListNode head) {
        if (head == null)
            return true;

        ArrayList<Integer> arr = new ArrayList<>();
        while (head != null) {
            arr.add(head.val);
            head = head.next;
        }

        for (int i = 0, j = arr.size() - 1; i < j; i++, j--) {
            // ERROR: !=
            if (!arr.get(i).equals(arr.get(j)))
                return false;
        }
        return true;
    }
}

public class Palindrome_Linked_List_v1 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] testset = { { 1, 2 }, { 1, 2, 2, 1 }, { 1, 2, 3, 2, 1 }, { -129, -129 } };
        for (int[] nums : testset) {
            ListNode head = ListUtils.buildList(nums);
            System.out.println(solution.isPalindrome(head));
        }
    }
}