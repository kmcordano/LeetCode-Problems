class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def removeNthFromEnd(self, head: ListNode, n: int) -> ListNode:
        node = head
        length = 0
        
        while node:
            length += 1
            node = node.next
        
        previous = None
        node = head
        for i in range(length - n):
            previous = node
            node = node.next

        if not previous:
            return node.next
        else:
            previous.next = node.next
    
        return head