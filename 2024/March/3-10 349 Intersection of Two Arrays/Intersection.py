from typing import List

class Solution:
    def intersection(self, nums1: List[int], nums2: List[int]) -> List[int]:
        set1 = set(())
        set2 = set(())

        for i in nums1:
            set1.add(i)
        
        for i in nums2:
            set2.add(i)

        result = set1.intersection(set2)
        return list(result)