class Solution:
    def isPowerOfTwo(n: int) -> bool:
        if n <= 0:
            return 0;

        return (n & n-1) == 0
    
print(Solution.isPowerOfTwo(5))