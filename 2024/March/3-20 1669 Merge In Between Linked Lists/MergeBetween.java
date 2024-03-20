
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode list2Head = list2;
        ListNode list2Tail = list2;
        while(list2Tail.next != null) {
            list2Tail = list2Tail.next;
        }

        ListNode node = list1;
        ListNode prev = null;
        for(int i = 0; ; i++) {
            if(i == a) {
                prev.next = list2Head;
            }
            if(i == b) {
                list2Tail.next = node.next;
                break;
            }

            prev = node;
            node = node.next;
        }

        return list1;
    }
}