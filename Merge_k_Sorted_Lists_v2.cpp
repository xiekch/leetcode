/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
/**
 * time complexity: N*logk
 */
#include <queue>
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
        priority_queue<pair<int, ListNode *>> pq;
        int minimum = 0xfffff, index = -1;
        for (int i = 0; i < lists.size(); i++) {
            if (lists[i] != NULL) {
                pq.push(make_pair(-1 * lists[i]->val, lists[i]->next));
            }
        }
        while (!pq.empty()) {
            pair p = pq.top();
            pq.pop();
            p.first = -1 * p.first;
            addNode(head, tail, p.first);
            if (p.second != NULL) {
                pq.push(make_pair(-1 * p.second->val, p.second->next));
            }
        }
        return head;
    }
};