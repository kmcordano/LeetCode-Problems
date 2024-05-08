from typing import List

class Solution:
    def findMaxK(self, nums: List[int]) -> int:
        positives = set()
        negatives = set()
        num = -1

        for i in nums:
            if i > 0:
                if i in negatives:
                    if i > num:
                        num = i
                else:
                    positives.add(i)
            else :
                pos = abs(i)
                if pos in positives:
                    if pos > num:
                        num = pos
                else:
                    negatives.add(pos)
        
        return num
                