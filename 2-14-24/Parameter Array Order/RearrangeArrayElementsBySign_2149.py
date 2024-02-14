from typing import List

class Solution:
   def rearrangeArray(self, nums: List[int]) -> List[int]:
      posIndex = 0
      negIndex = 1
      solution = [0] * len(nums)

      for curNum in nums:
         if curNum > 0:
            solution[posIndex] = curNum
            posIndex += 2
         else:
            solution[negIndex] = curNum
            negIndex += 2

      return solution

