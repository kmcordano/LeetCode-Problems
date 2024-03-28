from typing import List

class Solution:
    def maxSubarrayLength(self, nums: List[int], k: int) -> int:
        front = 0
        back = 0
        length = 0
        max = 0
        counts = {}

        while back < len(nums) and front < len(nums):
            counts[nums[front]] = counts.get(nums[front], 0) + 1
            if counts[nums[front]] > k:
                while back < front and nums[back] != nums[front]:
                    counts[nums[back]] = counts[nums[back]] - 1
                    back += 1
                counts[nums[back]] = counts[nums[back]] - 1
                back += 1

            length = front - back + 1
            if length > max:
                max = length
            front += 1

        return max

