import java.util.Stack;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public void reorderList(ListNode head) {
        int listCount = 0;
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode node = head;
        while(node != null) {
            stack.push(node);
            node = node.next;
            listCount++;
        }

        if(listCount <= 2) {
            return;
        }

        ListNode temp;
        for(int i = 0; i < listCount; i += 2) {
            temp = head.next;
            head.next = stack.pop();
            head.next.next = temp;
            head = head.next.next;
        }
        head.next = null;
    }
}