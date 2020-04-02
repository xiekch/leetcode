#include <set>
using namespace std;
// Given a linked list, determine if it has a cycle in it.
// Definition for singly-linked list.
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
  public:
    ListNode *detectCycle(ListNode *head) {
        set<ListNode *> s;
        while (head != NULL) {
            if (s.count(head) == 0) {
                s.insert(head);
            } else {
                return head;
            }
            head = head->next;
        }
        return NULL;
    }
};