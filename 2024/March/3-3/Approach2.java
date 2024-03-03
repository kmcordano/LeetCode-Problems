public class Approach2 {
    public static void main(String[] args) {

    }
}

class Solution {
    private ListNode head;
    private int n;
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        this.head = head;
        this.n = n;
        
        recursiveRemove(null, head);

        return this.head;
    }

    private int recursiveRemove(ListNode previous, ListNode node) {
        if(node == null) {
            return 1;
        }

        int depth = recursiveRemove(node, node.next);
        if(depth == n) {
            if(previous == null) {
                head = node.next;
            }
            else {
                previous.next = node.next;
            }
        }

        return depth + 1;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}