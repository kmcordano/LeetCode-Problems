from typing import List

class Solution:
    def maximalRectangle(self, matrix: List[List[str]]) -> int:
        scanned = [0] * len(matrix[0])
        scannedMax = 0
        maxArea = 0

        def findMax(row: List[int]) -> int:
            maxRowArea = 0

            for i, val in enumerate(row):
                if val == 0:
                    continue

                iterMax = val
                for left in range(i - 1, -1, -1):
                    if row[left] == 0 or row[left] < val:
                        break
                    iterMax += val
                
                for right in range(i + 1, len(row), 1):
                    if row[right] == 0 or row[right] < val:
                        break
                    iterMax += val

                if iterMax > maxRowArea:
                    maxRowArea = iterMax
            
            return maxRowArea

        for row in matrix:
            for i, val in enumerate(row):
                if val == '0':
                    scanned[i] = 0
                else:
                    scanned[i] = scanned[i] + 1
            
            scannedMax = findMax(scanned)
            if scannedMax > maxArea:
                maxArea = scannedMax
        
        return maxArea