class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        def recursiveRemove(prev: ListNode, node: ListNode) -> int:
            nonlocal head
            
            if not node:
                return 1
            
            depth = recursiveRemove(node, node.next)
            if depth == n:
                if not prev:
                    head = node.next
                else:
                    prev.next = node.next

            return depth + 1

        recursiveRemove(None, head)
        return head