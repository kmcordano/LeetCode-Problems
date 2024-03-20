class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

class Solution:
    def mergeInBetween(self, list1: ListNode, a: int, b: int, list2: ListNode) -> ListNode:
        list2Head = list2
        list2Tail = list2
        while list2Tail.next:
            list2Tail = list2Tail.next

        node = list1
        prev = None
        i = 0
        while node:
            if i == a:
                prev.next = list2Head
            if i == b:
                list2Tail.next = node.next
                break
            
            prev = node
            node = node.next
            i += 1
        
        return list1