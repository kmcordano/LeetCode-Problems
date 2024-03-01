from typing import List

class Solution:
    def findLeastNumOfUniqueInts(arr: List[int], k: int) -> int:
        # Retrieve mapping of values to count from arr
        numCounts = {}
        for i in arr:
           numCounts[i] = numCounts.get(i, 0) + 1
        
        # Take values of unique elements and sort
        counts = sorted(numCounts.values())
        uniqueCount = len(counts)

        # Remove k items
        for i in counts:
            dif = k - i
            if dif >= 0:
                k = dif
            else:
                break
                
            uniqueCount -= 1

        return uniqueCount
       

print(Solution.findLeastNumOfUniqueInts([4, 3, 1, 1, 3, 3, 2], 1))