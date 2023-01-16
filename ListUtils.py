

from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def buildList(values) -> Optional[ListNode]:
    if values is None or len(values) == 0:
        return None
    head = ListNode(values[0])
    node = head
    for i in values[1:]:
        node.next = ListNode(i)
        node = node.next

    return head


def printList(head: Optional[ListNode]):
    if head is not None:
        print(head.val, end='')
        head = head.next
    while head is not None:
        print('->'+str(head.val), end='')
        head = head.next
    print()
