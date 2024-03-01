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
    private int maxDiameter;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;

        maxDepth(root);

        return maxDiameter;
    }

    private int maxDepth(TreeNode node) {
        if(node == null) {
            return 0;
        }
        
        int leftDepth = 0;
        int rightDepth = 0;
        
        leftDepth = maxDepth(node.left);
        rightDepth = maxDepth(node.right);
        

        int diameter = leftDepth + rightDepth;
        if(diameter > maxDiameter) {
            maxDiameter = diameter;
        }

        return (leftDepth > rightDepth) ? (leftDepth + 1) : (rightDepth + 1);
    }
}