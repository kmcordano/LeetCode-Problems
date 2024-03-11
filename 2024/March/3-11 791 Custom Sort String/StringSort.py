class Solution:
    def customSortString(self, order: str, s: str) -> str:
        priorityMap = {}
        priority = 1
        for i in range(len(order)):
            priorityMap[order[i]] = priority
            priority += 1

        result = list(s)
        result.sort(key = lambda c : priorityMap.get(c, 0))

        return ''.join(result)