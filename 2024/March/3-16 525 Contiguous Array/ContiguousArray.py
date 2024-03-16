from typing import List

class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        sums = [0] * len(nums)
        acc = 0
        firstInstance = {}
        maxZero = -1
        maxInterval = 0

        for i in len(nums):
            if nums[i] == 0:
                acc -= 1
            else:
                acc += 1

            if acc == 0:
                maxZero = i
            else:
                if acc not in firstInstance:
                    firstInstance[acc] = i
                else:
                    if i - firstInstance[acc] > maxInterval:
                        maxInterval = i - firstInstance[acc]
            
            sums[i] = acc
        
        if maxZero > maxInterval:
            return maxZero + 1
        
        return maxInterval