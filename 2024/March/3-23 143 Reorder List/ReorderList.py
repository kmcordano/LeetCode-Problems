from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def reorderList(self, head: Optional[ListNode]) -> None:
        listCount = 0
        stack = []
        node = head
        while node:
            stack.append(node)
            node = node.next
            listCount += 1
        
        if listCount <= 2:
            return
        
        for i in range(0, listCount, 2):
            temp = head.next
            head.next = stack.pop()
            head.next.next = temp
            head = head.next.next
        head.next = None
        