from typing import List

class Solution:
    def minOperations(self, nums: List[int], k: int) -> int:
        for i in reversed(nums):
            k = k ^ i
        return int.bit_count(k)