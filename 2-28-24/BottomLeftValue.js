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
var findBottomLeftValue = function(root) {
    const depthFirstSearch = function(node, depth) {
        if(node === null) {
            return;
        }

        if(depth > maxDepth) {
            maxDepth = depth;
            returnVal = node.val;
        }

        depthFirstSearch(node.left, depth + 1);
        depthFirstSearch(node.right, depth + 1);
    }

    maxDepth = -1;
    returnVal = 0;

    depthFirstSearch(root, 0)

    return returnVal;
};