class Solution:
    def rangeBitwiseAnd(self, left: int, right: int) -> int:
        while right > left:
            right = right & (right - 1)
        while left != right:
            left = left & (left - 1)
        
        return left;