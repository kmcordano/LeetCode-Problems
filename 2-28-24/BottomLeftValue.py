# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def findBottomLeftValue(self, root: Optional[TreeNode]) -> int:
        def depthFirstSearch(node: TreeNode, depth: int, maxDepth: int, returnVal: int):
            if not node:
                return

            if depth > maxDepth[0]:
                maxDepth[0] = depth
                returnVal[0] = node.val

            depthFirstSearch(node.left, depth + 1, maxDepth, returnVal)
            depthFirstSearch(node.right, depth + 1, maxDepth, returnVal)

        maxDepth = [-1]
        returnVal = [root.val]

        depthFirstSearch(root, 0, maxDepth, returnVal)

        return returnVal[0]