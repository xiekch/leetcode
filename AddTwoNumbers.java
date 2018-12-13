
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry=0,sum;
        ListNode l=null;
        ListNode head=null;
        while(l1!=null&&l2!=null){
            sum=l1.val+l2.val+carry;
            if(sum>9){
                sum-=10;
                carry=1;
            }else carry=0;
            if(l!=null) {l.next=new ListNode(sum);l=l.next;}
            else l=new ListNode(sum);
            
            if(head==null)head=l;
            l1=l1.next;
            l2=l2.next;
        }

        while(l1!=null){
            sum=l1.val+carry;
            if(sum>9){
                sum-=10;
                carry=1;
            }else carry=0;
            if(l!=null) {l.next=new ListNode(sum);l=l.next;}
            else l=new ListNode(sum);

            if(head==null)head=l;
            l1=l1.next;
        }
        
        while(l2!=null){
            sum=l2.val+carry;
            if(sum>9){
                sum-=10;
                carry=1;
            }else carry=0;
            if(l!=null) {l.next=new ListNode(sum);l=l.next;}            
            else l=new ListNode(sum);
            
            if(head==null)head=l;
            l2=l2.next;
        }

        if(carry!=0){
            sum=carry;
            if(l!=null) {l.next=new ListNode(sum);l=l.next;}            
            else l=new ListNode(sum);
            
            if(head==null)head=l;            
        }

        return head;
    }

}