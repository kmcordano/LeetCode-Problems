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
    public String smallestFromLeaf(TreeNode root) {
        return recursiveHelper(root, "");
    }

    private String recursiveHelper(TreeNode node, String str) {
        str = getCharacter(node.val) + str;

        if(node.left == null && node.right == null) {
            return str;
        }

        String left = "";
        String right = "";
        if(node.left != null) {
            left = recursiveHelper(node.left, str);
        }
        if(node.right != null) {
            right = recursiveHelper(node.right, str);
        }

        return lexicographicallySmallest(left, right);
    }

    private String lexicographicallySmallest(String left, String right) {
        int lLength = left.length();
        int rLength = right.length();
        if(lLength == 0 && rLength == 0) {
            return "";
        }
        if(lLength == 0 && rLength != 0) {
            return right;
        }
        if(lLength != 0 && rLength == 0) {
            return left;
        }

        for(int i = 0; i < lLength && i < rLength; i++) {
            if(left.charAt(i) < right.charAt(i)) {
                return left;
            }
            else if(right.charAt(i) < left.charAt(i)) {
                return right;
            }
        }

        return (lLength < rLength) ? (left) : (right);
    }

    private char getCharacter(int val) {
        return (char) (val + 97);
    }
}