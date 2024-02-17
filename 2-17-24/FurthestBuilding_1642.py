from typing import List
import heapq

class Solution:
    def furthestBuilding(heights: List[int], bricks: int, ladders: int) -> int:
        if ladders > len(heights):
            return len(heights)
        
        collectiveDif = 0
        currentDif = 0
        laddersLeft = ladders
        jumps = []

        for i in range(len(heights)):
            currentDif = heights[i+1] - heights[i]
            if(currentDif > 0):
                heapq.heappush(jumps, -currentDif)
                collectiveDif += currentDif
                if(collectiveDif > bricks):
                    if laddersLeft <= 0:
                        return i
                    collectiveDif -= -heapq.heappop(jumps)
                    laddersLeft -= 1

        return len(heights) - 1
                
heights = [4, 2, 7, 6, 9, 14, 12]
print(Solution.furthestBuilding(heights, 5, 1))