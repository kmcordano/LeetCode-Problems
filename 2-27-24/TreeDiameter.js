/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */

var maxDiameter;

/**
 * @param {TreeNode} root
 * @return {number}
 */
var diameterOfBinaryTree = function(root) {
    maxDiameter = 0;
    maxDepth(root);
    return maxDiameter;
};

const maxDepth = function(node) {
    if(!node) {
        return 0;
    }

    var leftDepth = maxDepth(node.left);
    var rightDepth = maxDepth(node.right);

    var diameter = leftDepth + rightDepth;
    if(diameter > maxDiameter) {
        maxDiameter = diameter;
    }

    return (leftDepth > rightDepth) ? (leftDepth + 1) : (rightDepth + 1);
}

