from cgi import test
from email import header
from typing import Optional
from ListUtils import *

# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next


class Solution:
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        if head is None or head.next is None:
            return head

        res = ListNode(next=head)

        node = res
        for i in range(1, left):
            node = node.next
        prevNode = node
        beginNode = node.next

        prev = beginNode
        node = beginNode.next
        for i in range(left, right):
            temp = node.next
            node.next = prev
            prev = node
            node = temp

        beginNode.next = node
        prevNode.next = prev
        return res.next


if __name__ == '__main__':
    solution = Solution()
    testCases = [{'head': [1, 2, 3, 4, 5], 'left': 2, 'right': 4},
                 {'head': [1, 2, 3, 4, 5], 'left': 1, 'right': 4},
                 {'head': [1, 2, 3, 4, 5], 'left': 2, 'right': 5},
                 {'head': [1, 2, 3, 4, 5], 'left': 1, 'right': 5},
                 {'head': [1, 2], 'left': 1, 'right': 2},
                 {'head': [1], 'left': 1, 'right': 1},
                 {'head': [1, 2], 'left': 1, 'right': 1}]

    for testCase in testCases:
        printList(solution.reverseBetween(
            buildList(testCase['head']), testCase['left'], testCase['right']))
