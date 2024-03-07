import java.util.LinkedList;

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
    public boolean isEvenOddTree(TreeNode root) {
        return breadthFirstSearch(root);   
    }

    private boolean breadthFirstSearch(TreeNode node) {
        LinkedList<Pair> queue = new LinkedList<Pair>();

        queue.offer(new Pair(node, 0));

        Pair currentPair;
        int previousVal = -1;
        int previousLevel = -1;
        while(!queue.isEmpty()) {
            currentPair = queue.poll();

            /* Base cases */
            if(currentPair.node() == null) {
                continue;
            }
            if(currentPair.node().val % 2 == currentPair.level() % 2) {
                return false;
            }

            /* Check for level compliance */
            if(currentPair.level() == previousLevel) {
                if(currentPair.level() % 2 == 0) {
                    if(currentPair.node().val <= previousVal) {
                        return false;
                    }
                }
                else {
                    if(currentPair.node().val >= previousVal) {
                        return false;
                    }
                }
            }

            previousVal = currentPair.node().val;
            previousLevel = currentPair.level();
            queue.offer(new Pair(currentPair.node().left, currentPair.level() + 1));
            queue.offer(new Pair(currentPair.node().right, currentPair.level() + 1));
        }

        return true;
    }
}

class Pair {
    private TreeNode node;
    private int level;

    public Pair(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }

    public String toString() {
        return "[" + node.val + ", " + level + "]";
    }

    public TreeNode node() { return node; }
    public int level() { return level; }
}