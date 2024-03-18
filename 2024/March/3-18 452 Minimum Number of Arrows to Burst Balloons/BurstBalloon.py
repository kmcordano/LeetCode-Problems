from typing import List

class Solution:
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        points.sort(key = lambda a : a[1])

        currentPairPointer = 0
        x = points[0][1]
        arrowsThrown = 1

        while currentPairPointer < len(points):
            if x >= points[currentPairPointer][0] and x <= points[currentPairPointer][1]:
                currentPairPointer += 1
            else:
                arrowsThrown += 1
                x = points[currentPairPointer][1]
        
        return arrowsThrown
