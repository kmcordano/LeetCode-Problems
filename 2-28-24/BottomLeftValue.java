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
    int maxDepth;
    int returnVal;

    public int findBottomLeftValue(TreeNode root) {
        /* returnVal variables */
        maxDepth = -1;  // Tracks depth
        returnVal = 0;  // Value of leftmost node
        
        depthFirstSearch(root, 0);
        
        return returnVal;
    }

    private void depthFirstSearch(TreeNode node, int depth) {
        if(node == null) {  // Base case
            return;
        }

        /* Because the recursive calls trace the left side first, only the depth matters */
        if(depth > maxDepth) {  
            maxDepth = depth;   
            returnVal = node.val;
        }

        depthFirstSearch(node.left, depth + 1);
        depthFirstSearch(node.right, depth + 1);
    }
}
