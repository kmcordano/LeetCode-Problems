/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean evaluateTree(TreeNode root) {
        return evaluate(root);
    }

    private boolean evaluate(TreeNode node) {
        switch(node.val) {
            case 0:
                return false;
            case 1:
                return true;
            case 2:
                return evaluate(node.left) || evaluate(node.right);
            case 3:
                return evaluate(node.left) && evaluate(node.right);
            default:
                return false;
        }
    }
}