class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        def recursiveResult(node: ListNode) -> bool:
            if not node:
                return True
            
            nonlocal next
            
            if recursiveResult(node.next):
                if node.val == next.val:
                    next = next.next
                    return True
                else:
                    return False
            else:
                return False  
        
        next = head          
        return recursiveResult(head)