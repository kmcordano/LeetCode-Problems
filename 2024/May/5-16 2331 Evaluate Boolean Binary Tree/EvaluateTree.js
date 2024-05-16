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
 * @return {boolean}
 */
var evaluateTree = function(root) {
    var evaluate = (node) => {
        switch(node.val) {
            case 0:
                return false;
            case 1:
                return true;
            case 2:
                return evaluate(node.left) || evaluate(node.right);
            case 3:
                return evaluate(node.left) && evaluate(node.right);
        }
    };

    return evaluate(root);
};