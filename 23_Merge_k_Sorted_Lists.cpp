/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
/**
 * time complexity: N*k
 */

#include <vector>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
    void addNode(ListNode *&head, ListNode *&tail, int &val) {
        if (NULL == head) {
            head = new ListNode(val);
            tail = head;
        } else {
            tail->next = new ListNode(val);
            tail = tail->next;
        }
    }

  public:
    ListNode *mergeKLists(vector<ListNode *> &lists) {
        ListNode *head = NULL, *tail = NULL;
        while (true) {
            int minimum = 0xfffff, index = -1;
            for (int i = 0; i < lists.size(); i++) {
                if (lists[i] != NULL) {
                    if (lists[i]->val < minimum) {
                        minimum = lists[i]->val;
                        index = i;
                    }
                }
            }
            if (index == -1) {
                break;
            }

            addNode(head, tail, minimum);
            lists[index] = lists[index]->next;
        }
        return head;
    }
};