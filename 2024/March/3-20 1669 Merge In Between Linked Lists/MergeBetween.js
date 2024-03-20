/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} list1
 * @param {number} a
 * @param {number} b
 * @param {ListNode} list2
 * @return {ListNode}
 */
var mergeInBetween = function(list1, a, b, list2) {
    let list2Head = list2;
    let list2Tail = list2;
    while(list2Tail.next) {
        list2Tail = list2Tail.next
    }

    let node = list1;
    let prev = null;
    for(let i = 0; ; i++) {
        if(i === a) {
            prev.next = list2Head;
        }
        if(i === b) {
            list2Tail.next = node.next;
            break;
        }

        prev = node;
        node = node.next;
    }

    return list1;
};