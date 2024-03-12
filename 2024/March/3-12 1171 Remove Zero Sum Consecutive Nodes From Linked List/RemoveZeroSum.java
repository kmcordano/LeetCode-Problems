/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        /* Base Case */
        if(head == null) {
            return head;
        }

        /* Remove all eligible sublists and connect to head */
        head.next = removeZeroSumSublists(head.next);

        ListNode to = head;
        int sum = 0;

        /* Check for eligibility from head */
        while(to != null) {
            sum += to.val;
            if(sum == 0) {
                return to.next;
            }
            else {
                to = to.next;
            }
        }

        return head;
    }
}