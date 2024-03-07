
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
    var node = head;
    var length = 0;

    while(node) {
        length++;
        node = node.next;
    }

    var prev = null;
    node = head;
    for(var i = length - n; i > 0; i--) {
        prev = node;
        node = node.next;
    }

    if(!prev) {
        return node.next;
    }
    else {
        prev.next = node.next;
    }

    return head;
};