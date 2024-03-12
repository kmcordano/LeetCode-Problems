from typing import Optional

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def removeZeroSumSublists(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head:
            return head

        head.next = self.removeZeroSumSublists(head.next)

        to = head
        sum = 0

        while(to):
            sum += to.val
            if sum == 0:
                return to.next
            else:
                to = to.next
        
        return head