from typing import List

class Solution:
    def numSubarraysWithSum(nums: List[int], goal: int) -> int:
        return atMost(goal, nums) - atMost(goal - 1, nums)

def atMost(goal: int, nums: List[int]):
    if len(nums) == 0:
        return 0
        
    num1s = 0
    count = 0
    for num in nums:
        if num == 1:
            num1s += 1
        
        if num1s > goal:
            break
        
        count += 1

    return count + atMost(goal, nums[1:])

input = [1,0,1,0,1]
print(Solution.numSubarraysWithSum(input, 2))
