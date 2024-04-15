/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number}
 */
var sumNumbers = function(root) {
    var recursiveHelper = (node, val) => {
        if(!node) {
            return 0;
        }

        val += node.val;

        if(!node.left && !node.right) {
            return parseInt(val);
        }

        return recursiveHelper(node.left, val) + recursiveHelper(node.right, val);
    };

    return recursiveHelper(root, "");
};