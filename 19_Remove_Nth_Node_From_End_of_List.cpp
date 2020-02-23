#include <stdio.h>
// Definition for singly-linked list.
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
  public:
    ListNode *removeNthFromEnd(ListNode *head, int n) {
        if (head == NULL)
            return head;
        
        ListNode *dummy = new ListNode(0);
        dummy->next = head;
        int count = 0;
        ListNode *par = dummy, *tail = dummy;
        for (size_t i = 0; i < n; i++) {
            tail = tail->next;
        }

        while (tail->next != NULL) {
            tail = tail->next;
            par = par->next;
        }

        if (par->next != NULL)
            par->next = par->next->next;

        return dummy->next;
    }
};