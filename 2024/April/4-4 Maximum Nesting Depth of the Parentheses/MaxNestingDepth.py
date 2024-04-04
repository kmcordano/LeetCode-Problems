class Solution:
    def maxDepth(self, s: str) -> int:
        depth = 0
        maxDepth = 0

        for c in s:
            if c == "(":
                depth += 1
                if depth > maxDepth:
                    maxDepth = depth
            elif c == ")":
                depth -= 1
        
        return maxDepth