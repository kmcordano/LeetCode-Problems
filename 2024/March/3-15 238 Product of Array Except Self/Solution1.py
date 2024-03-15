from typing import List

class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        prefix = [0] * len(nums)
        suffix = [0] * len(nums)

        product = 1
        for i in range(len(nums)):
            prefix[i] = product
            product *= nums[i]

        product = 1
        for i in reversed(range(len(nums))):
            suffix[i] = product
            product *= nums[i]

        result = [0] * len(nums)
        for i in range(len(result)):
            result[i] = prefix[i] * suffix[i]

        return result