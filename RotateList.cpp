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
    ListNode *rotateRight(ListNode *head, int k) {
        if (head == nullptr || head->next == nullptr)
            return head;
        ListNode *temp = head, *prev;
        int size = 0;
        while (temp) {
            size++;
            prev = temp;
            temp = temp->next;
        }
        prev->next = head;

        int n = k % size;
        temp = head;
        for (int i = size - n; i > 0; i--) {
            prev = temp;
            temp = temp->next;
        }
        prev->next = nullptr;

        return temp;
    }
};