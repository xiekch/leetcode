#pragma once
#include <iostream>
#include <vector>
using std::cout;
using std::endl;
using std::vector;

struct ListNode {
    int val;
    ListNode *next;
    ListNode() : next(NULL) {}
    ListNode(int x) : val(x), next(NULL) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};

class ListUtil {
  private:
  public:
    ListUtil() {}
    static ListNode *build(const vector<int> &nums) {
        ListNode dummy, *p = &dummy;
        for (int i : nums) {
            p->next = new ListNode(i);
            p = p->next;
        }
        return dummy.next;
    }
    ~ListUtil() {}

    static void printList(ListNode *head) {
        while (head != NULL) {
            cout << head->val << " ";
            head = head->next;
        }
        cout << endl;
    }
};
