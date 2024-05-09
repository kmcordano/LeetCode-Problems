from typing import List

class Solution:
    def maximumHappinessSum(self, happiness: List[int], k: int) -> int:
        happiness.sort(reverse=True)
        offset = 0
        result = 0
        for i in range(k):
            if happiness[i] - offset > 0:
                result += happiness[i] - offset
            offset += 1
        
        return result