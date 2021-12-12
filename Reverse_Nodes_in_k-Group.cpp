#include "list_utils.h"

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */

class Solution {
public:
    ListNode* reverseKGroup(ListNode* head, int k) {
        if (head == nullptr || head->next == nullptr || k <= 1)
            return head;
        ListNode* cur = head;

        for (int i = 0; i < k - 1; i++) {
            cur = cur->next;
            if (cur == nullptr) {
                return head;
            }
        }
        cur = head;
        ListNode *next = cur->next,
                 *prev = nullptr;
        for (int i = 0; i < k; i++) {
            next = cur->next;
            cur->next = prev;
            prev = cur;
            cur = next;
        }

        head->next = reverseKGroup(cur, k);
        return prev;
    }
};

int main(int argc, char const* argv[]) {
    Solution solution;
    vector<int> testCases[] = {
        vector<int>{1, 2, 3, 4, 5, 6, 7, 8, 9}};
    for (auto testCase : testCases) {
        ListUtil::printList(solution.reverseKGroup(ListUtil::build(testCase), 2));
        ListUtil::printList(solution.reverseKGroup(ListUtil::build(testCase), 3));
    }

    return 0;
}
