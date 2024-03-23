function ListNode(val, next) {
    this.val = (val===undefined ? 0 : val)
    this.next = (next===undefined ? null : next)
}

/**
 * @param {ListNode} head
 * @return {void} Do not return anything, modify head in-place instead.
 */
var reorderList = function(head) {
    var listCount = 0;
    var stack = [];
    var node = head;

    while(node) {
        stack.push(node);
        node = node.next;
        listCount++;
    }

    if(listCount <= 2) {
        return;
    }

    var temp;
    for(var i = 0; i < listCount; i += 2) {
        temp = head.next;
        head.next = stack.pop();
        head.next.next = temp;
        head = head.next.next;
    }
    head.next = null;    
};