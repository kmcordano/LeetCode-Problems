from typing import List

class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        if not intervals:
            return [newInterval]
        
        starts = []
        ends = []
        solution = []

        for interval in intervals:
            starts.append(interval[0])
            ends.append(interval[1])

        starts.append(newInterval[0])
        ends.append(newInterval[1])

        starts.sort()
        ends.sort()
        
        while starts and ends:
            start = starts.pop(0)
            end = ends.pop(0)
            while starts and ends and end >= starts[0]:
                starts.pop(0)
                end = ends.pop(0)
            solution.append([start, end])

        return solution