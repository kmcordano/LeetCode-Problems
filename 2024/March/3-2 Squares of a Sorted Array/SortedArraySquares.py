from typing import List

class Solution:
    def sortedSquares(nums: List[int]):
        if len(nums) == 1:
            return [nums[0] * nums[0]]
        
        posI = 0
        sorted = [0] * len(nums)
        sortedI = 0

        while posI < len(nums) and nums[posI] < 0:
            posI += 1
        negI = posI - 1

        while negI >= 0 and posI < len(nums):
            posSqr = nums[posI] * nums[posI]
            negSqr = nums[negI] * nums[negI]

            if posSqr < negSqr:
                sorted[sortedI] = posSqr
                posI += 1
                sortedI += 1
            else:
                sorted[sortedI] = negSqr
                negI -= 1
                sortedI += 1
        
        while negI >= 0:
            sorted[sortedI] = nums[negI] * nums[negI]
            negI -= 1
            sortedI += 1

        while posI < len(nums):
            sorted[sortedI] = nums[posI] * nums[posI]
            posI += 1
            sortedI += 1

        return sorted
    
nums = [-7,-3,2,3,11]
print(Solution.sortedSquares(nums))