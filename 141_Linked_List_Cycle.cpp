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
    bool hasCycle(ListNode *head) {
        set<ListNode *> s;
        while (head != NULL) {
            if (s.count(head) == 0) {
                s.insert(head);
                head = head->next;
            } else {
                return true;
            }
        }
        return false;
    }
};