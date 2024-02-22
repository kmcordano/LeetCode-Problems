from typing import List

class Solution:
    def findJudge(n: int, trust: List[List[int]]) -> int:
        trustsSomeone = [False] * n
        trustCount = [0] * n

        for trusts in trust:
            trustsSomeone[trusts[0] - 1] = True
            trustCount[trusts[1] - 1] = trustCount[trusts[1] - 1] + 1

        for i in range(n):
            if (not trustsSomeone[i]) and (trustCount[i] == n-1):
                return i + 1
            
        return -1
    
input = [[1,3],[2,3]]
print(Solution.findJudge(3, input))