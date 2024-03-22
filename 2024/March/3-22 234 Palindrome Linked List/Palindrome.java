
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    ListNode next;
    
    public boolean isPalindrome(ListNode head) {
        next = head;
        return recursiveResult(head);
    }

    private boolean recursiveResult(ListNode node) {
        if(node == null) {
            return true;
        }

        if(recursiveResult(node.next)) {
            if(node.val == next.val) {
                next = next.next;
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }
}