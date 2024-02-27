# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def diameterOfBinaryTree(self, root: Optional[TreeNode]) -> int:
        def maxDepth(node, maxDiameter) -> int:
            if not node:
                return 0

            leftDepth = maxDepth(node.left, maxDiameter)
            rightDepth = maxDepth(node.right, maxDiameter)

            if leftDepth + rightDepth > maxDiameter[0]:
                maxDiameter[0] = leftDepth + rightDepth

            return leftDepth + 1 if leftDepth > rightDepth else rightDepth + 1

        maxDiameter = [0]
        maxDepth(root, maxDiameter)
        return maxDiameter[0]
