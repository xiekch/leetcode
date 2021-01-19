#include <vector>
using namespace std;
// A linked list is given such that each node contains an additional
//  random pointer which could point to any node in the list or null.
// Return a deep copy of the list.

// a deep copy of a directed graph
// Definition for a Node.
class Node {
  public:
    int val;
    Node *next;
    Node *random;

    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};

// a more subtle solution
// https://leetcode.com/problems/copy-list-with-random-pointer/discuss/43491/A-solution-with-constant-space-complexity-O(1)-and-linear-time-complexity-O(N)
// O(n2)
class Solution {
  public:
    Node *copyRandomList(Node *head) {
        vector<Node *> list1, list2;
        Node *dummy = new Node(0);
        Node *p1 = head, *p2 = dummy;
        while (p1 != NULL) {
            p2->next = new Node(p1->val);
            list1.push_back(p1);
            list2.push_back(p2->next);
            p1 = p1->next;
            p2 = p2->next;
        }

        for (int i = 0; i < list1.size(); i++) {
            if (list1[i]->random == NULL) {
                continue;
            }
            int j;
            for (j = 0; j < list1.size(); j++) {
                if (list1[i]->random == list1[j]) {
                    break;
                }
            }
            if (j < list1.size())
                list2[i]->random = list2[j];
        }
        return dummy->next;
    }
};