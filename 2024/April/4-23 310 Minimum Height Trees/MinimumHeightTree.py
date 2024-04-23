from typing import List

class Solution:
    def findMinHeightTrees(self, n: int, edges: List[List[int]]) -> List[int]:
        solutions = []
        if n == 1:
            solutions.append(0)
            return solutions
        
        connections = [0] * n
        edgeMap = {}
        for edge in edges:
            connections[edge[0]] += 1
            connections[edge[1]] += 1

            edgeMap.setdefault(edge[0], []).append(edge[1])
            edgeMap.setdefault(edge[1], []).append(edge[0])
        
        toRemove = []
        for i in range(n):
            if connections[i] == 1:
                toRemove.append(i)
        
        numRemoved = 0
        while n - numRemoved > 2:
            size = len(toRemove)
            numRemoved += size
            for i in range(size):
                node = toRemove.pop(0)
                for edge in edgeMap.get(node, []):
                    connections[edge] -= 1
                    if connections[edge] == 1:
                        toRemove.append(edge)
        
        solutions.extend(toRemove)
        return solutions