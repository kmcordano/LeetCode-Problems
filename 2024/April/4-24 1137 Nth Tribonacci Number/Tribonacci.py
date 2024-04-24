class Solution:
    def tribonacci(self, n: int) -> int:
        if n == 0:
            return 0
        if n == 1:
            return 1
        if n == 2:
            return 1

        n0 = 0
        n1 = 1
        n2 = 1
        n3 = 0
        for i in range(3, n + 1, 1):
            n3 = n0 + n1 + n2
            n0 = n1
            n1 = n2
            n2 = n3
        
        return n3