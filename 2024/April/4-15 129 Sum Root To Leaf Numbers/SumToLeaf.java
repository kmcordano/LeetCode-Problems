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
    public int sumNumbers(TreeNode root) {
        return recursiveHelper(root, "");
    }

    private int recursiveHelper(TreeNode node, String val) {
        if(node == null) {
            return 0;
        }

        val += node.val;

        if(node.left == null && node.right == null) {
            return Integer.valueOf(val);
        }

        return recursiveHelper(node.left, val) + recursiveHelper(node.right, val);
    }
}