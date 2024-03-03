
function ListNode(val, next) {
    this.val = (val===undefined ? 0 : val)
    this.next = (next===undefined ? null : next)
}

/**
 * @param {ListNode} head
 * @param {number} n
 * @return {ListNode}
 */
var removeNthFromEnd = function(head, n) {
    const recursiveRemove = function(prev, node) {
        if(!node) {
            return 1
        }

        var depth = recursiveRemove(node, node.next);
        if(depth == n) {
            if(!prev) {
                head = node.next;
            }
            else {
                prev.next = node.next;
            }
        }

        return depth + 1;
    };

    recursiveRemove(null, head);
    return head;
};