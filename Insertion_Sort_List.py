# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
from typing import Optional
from ListUtils import ListNode
from ListUtils import buildList
from ListUtils import printList


class Solution:
    def insertionSortList(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head is None:
            return head
        dummy = ListNode(next=head)
        cur: ListNode = head.next
        cur_prev: ListNode = head

        while cur is not None:
            if cur.val < cur_prev.val:
                node_prev = dummy
                node = node_prev.next
                while node.val < cur.val:
                    node_prev = node
                    node = node.next

                node_prev.next = cur
                cur_prev.next = cur.next
                cur.next = node

            cur_prev = cur
            cur = cur.next

        return dummy.next


if __name__ == '__main__':
    solution = Solution()
    testCases = [[4, 2, 1, 3], [-1, 5, 3, 4, 0]]
    for testCase in testCases:
        printList(solution.insertionSortList(buildList(testCase)))
