#include "list_utils.h"
#include <iostream>
#include <vector>
using namespace std;
// Sort a linked list in O(n log n) time using constant space complexity.
// Definition for singly-linked list.
// struct ListNode {
//     int val;
//     ListNode *next;
//     ListNode(int x) : val(x), next(NULL) {}
// };

class Solution {
    ListNode *merge(ListNode *a, ListNode *b) {
        ListNode dummpy(0), *p = &dummpy;
        while (a && b) {
            if (a->val < b->val) {
                p->next = a;
                a = a->next;
            } else {
                p->next = b;
                b = b->next;
            }

            p = p->next;
        }
        p->next = (a == NULL) ? b : a;
        return dummpy.next;
    }

  public:
    ListNode *sortList(ListNode *head) {
        if (head == NULL || head->next == NULL)
            return head;

        ListNode dummpy;
        dummpy.next = head;
        // split the chain
        ListNode *p1 = &dummpy, *p2 = &dummpy;
        while (p2 && p2->next) {
            p1 = p1->next;
            p2 = p2->next->next;
        }
        p2 = p1->next;
        p1->next = NULL;
        // ListUtil::printList(head);
        // ListUtil::printList(p2);
        head = sortList(head);
        p2 = sortList(p2);
        return merge(head, p2);
    }
};

int main(int argc, char const *argv[]) {
    // vector<int> test = {4, 2, 1, 3};
    vector<int> test = {4, 4, 3, 4, 6, 1, 0};
    ListNode *head = ListUtil::build(test);
    Solution sol;
    head = sol.sortList(head);
    ListUtil::printList(head);
    return 0;
}
