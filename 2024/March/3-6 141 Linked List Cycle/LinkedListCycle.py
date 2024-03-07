class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def hasCycle(self, head: ListNode) -> bool:
        fast = head
        slow = head
        loops = False

        while not loops:
            if fast is None:
                break
            
            fast = fast.next
            if fast is None:
                break
            fast = fast.next
            slow = slow.next
            if fast is None:
                break
            if fast == slow:
                loops = True
        
        return loops
        
        