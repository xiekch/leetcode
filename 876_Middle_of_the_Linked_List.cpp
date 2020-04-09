#include "list_utils.h"
#include <iostream>
using namespace std;

// Given a non-empty, singly linked list with head node head, return a middle
// node of linked list.
// If there are two middle nodes, return the second middle node.
// Definition for singly-linked list.
// struct ListNode {
//     int val;
//     ListNode *next;
//     ListNode(int x) : val(x), next(NULL) {}
// };
class Solution {
  public:
    ListNode *middleNode(ListNode *head) {
        if (head == NULL)
            return head;
        ListNode dummy(0);
        dummy.next = head;
        ListNode *fast = &dummy, *slow = &dummy;
        while (fast != NULL) {
            slow = slow->next;
            if (fast->next == NULL)
                break;
            fast = fast->next->next;
        }
        return slow;
    }
};

int main(int argc, char const *argv[]) {
    Solution sol;
    vector<vector<int>> testset = {{1, 2, 3, 4, 5}, {1, 2, 3, 4, 5, 6}, {1},{}};
    for (auto test : testset) {
        ListNode *head = ListUtil::build(test);
        ListUtil::printList(head);
        head = sol.middleNode(head);
        ListUtil::printList(head);
    }

    return 0;
}
