class Solution:
    def wonderfulSubstrings(self, word: str) -> int:
        prefixCounts = [0] * 1024
        count = 0
        prefix = 0
        prefixCounts[prefix] += 1
        for c in word:
            shift = ord(c) - ord('a')
            prefix ^= 1 << shift
            count += prefixCounts[prefix]
            for i in range(10):
                count += prefixCounts[prefix ^ 1 << i]
            prefixCounts[prefix] += 1
        return count
