from typing import List

class Solution:
    def largestPerimeter(nums: List[int]) -> int:
        nums.sort()
        
        sum = 0
        max = -1

        for cur in nums:
            if sum > cur:
                max = sum + cur

            sum += cur

        return max   

print(Solution.largestPerimeter([1, 12, 1, 2, 5, 50, 3]))     