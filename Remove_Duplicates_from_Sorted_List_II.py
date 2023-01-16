from cmath import nan
from typing import Optional
from ListUtils import *
# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next


class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if head is None:
            return head
        dummy = ListNode(val=nan, next=head)
        prev = dummy
        curr = head
        skip = False
        while curr is not None:
            if curr.next is not None and curr.next.val == curr.val:
                prev.next = curr.next
                skip = True
            elif skip:
                prev.next = curr.next
                skip = False
            else:
                prev = curr
            curr = curr.next

        return dummy.next


if __name__ == '__main__':
    solution = Solution()
    testCases = [[1, 2, 3, 3, 4, 4, 5], [1, 1, 1, 2, 3]]
    for testCase in testCases:
        printList(solution.deleteDuplicates(buildList(testCase)))
