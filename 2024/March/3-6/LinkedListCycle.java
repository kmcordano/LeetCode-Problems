
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;   // Fast incrementing pointer
        ListNode slow = head;   // Slow incrementing pointer
        boolean loops = false;  // Loops return val

        while(!loops) {
            if(fast == null) {  // If fast ever is null, there is no loop
                break;
            }

            fast = fast.next;
            if(fast == null) {
                break;
            }
            fast = fast.next;
            slow = slow.next;
            if(fast == null) {
                break;
            }
            if(fast == slow) {  // If fast catches up to slow, there must be a loop
                loops = true;
            }
        }

        return loops;
    }
}