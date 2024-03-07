/**
 * Definition for singly-linked list.
 * function ListNode(val) {
 *     this.val = val;
 *     this.next = null;
 * }
 */

/**
 * @param {ListNode} head
 * @return {boolean}
 */
var hasCycle = function(head) {
    var fast = head;
    var slow = head;
    var loops = false;

    while(!loops) {
        if(!fast) {
            break;
        }

        fast = fast.next;
        if(!fast) {
            break;
        }
        fast = fast.next;
        slow = slow.next;
        if(!fast) {
            break;
        }

        if(fast === slow) {
            loops = true;
        }
    }

    return loops;
};