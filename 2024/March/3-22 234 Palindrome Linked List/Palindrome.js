
function ListNode(val, next) {
    this.val = (val===undefined ? 0 : val)
    this.next = (next===undefined ? null : next)
}

/**
 * @param {ListNode} head
 * @return {boolean}
 */
var isPalindrome = function(head) {
    const recursiveResult = function(node) {
        if(!node) {
            return true;
        }

        if(recursiveResult(node.next)) {
            if(node.val === next.val) {
                next = next.next;
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    var next = head;
    return recursiveResult(head);
};