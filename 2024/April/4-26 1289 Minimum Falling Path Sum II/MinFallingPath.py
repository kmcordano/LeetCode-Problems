from typing import List

class Solution:
    def minFallingPathSum(self, grid: List[List[int]]) -> int:
        def minExclusive(row: List[int], exclude: int) -> int:
            rowMin = 1000000000
            for i, num in enumerate(row):
                if i == exclude:
                    continue
                if num < rowMin:
                    rowMin = num
            return rowMin

        previous = grid[len(grid) - 1]
        for i in range(len(grid) - 2, -1, -1):
            for j in range(len(previous)):
                grid[i][j] += minExclusive(previous, j)
            previous = grid[i]
        return minExclusive(previous, -1)
    