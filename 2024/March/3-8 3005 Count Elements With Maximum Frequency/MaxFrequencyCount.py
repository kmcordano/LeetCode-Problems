from typing import List

class Solution:
    def maxFrequencyElements(nums: List[int]) -> int:
        freqMap = {}
        maxFreq = 0
        for num in nums:
            newFreq = freqMap.get(num, 0) + 1
            freqMap[num] = newFreq
            if newFreq > maxFreq:
                maxFreq = newFreq

        count = 0
        for freq in freqMap.values():
            if freq == maxFreq:
                count += freq
        
        return count

nums = [1,2,2,3,1,4]
print(Solution.maxFrequencyElements(nums))