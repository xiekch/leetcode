class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int x) {
        this.val = x;
    }

    ListNode(int x, ListNode next) {
        this.val = x;
        this.next = next;
    }
};

public class ListUtils {
    public static ListNode buildList(int[] nums) {
        if (nums == null)
            return null;
        ListNode dummy = new ListNode(), p = dummy;
        for (int i : nums) {
            p.next = new ListNode(i);
            p = p.next;
        }
        return dummy.next;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.printf("%d ", head.val);
            head = head.next;
        }
        System.out.println();
    }
};
