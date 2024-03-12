/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} head
 * @return {ListNode}
 */
var removeZeroSumSublists = function(head) {
    if(!head) {
        return head;
    }

    head.next = removeZeroSumSublists(head.next);

    let to = head;
    let sum = 0;

    while(to) {
        sum += to.val;
        if(sum == 0) {
            return to.next;
        }
        else {
            to = to.next;
        }
    }

    return head;
};