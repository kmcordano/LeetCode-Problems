from typing import List

class Solution:
    def missingNumber(nums: List[int]) -> int:
        expectedSum = (len(nums) * (len(nums) + 1)) / 2
        actualSum = 0
        for i in nums:
            actualSum += i
        
        return expectedSum - actualSum
    
nums = [9,6,4,2,3,5,7,0,1]
print(Solution.missingNumber(nums))