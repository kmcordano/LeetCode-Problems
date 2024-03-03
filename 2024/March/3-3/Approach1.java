public class Approach1 {
    public static void main(String[] args) {

    }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = head;
        int length = 0;

        while(node != null) {
            length++;
            node = node.next;
        }

        ListNode previous = null;
        node = head;
        for(int i = length - n; i > 0; i--) {
            previous = node;
            node = node.next;
        }

        if(previous == null) {
            return node.next;
        }
        else {
            previous.next = node.next;
        }

        return head;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}