// ReverseLinkedList
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* reverseList(ListNode* head) {
        ListNode* prev=nullptr;
        ListNode* curr=head;
        ListNode* temp;

        while(curr){
            temp=curr->next;
            curr->next=prev;
            prev=curr;
            curr=temp;
        }

        return prev;
    }

    // ListNode* reverseList(ListNode* head) {
    //     if(head==nullptr||head->next==nullptr)return head;
    //     ListNode*temp=reverseList(head->next);
    //     head->next->next=head;
    //     head->next=nullptr;
    //     return temp;
    // }
};