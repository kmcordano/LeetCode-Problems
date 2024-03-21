class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    ListNode newHead;
    public ListNode reverseList(ListNode head) {
        if(head == null) {
            return null;
        }
        recursiveReturn(head);
        return newHead;
    }

    private ListNode recursiveReturn(ListNode node) {
        if(node.next == null) {
            newHead = node;
            return node;
        }

        ListNode tail = recursiveReturn(node.next);
        tail.next = node;
        node.next = null;
        return node;
    }
}