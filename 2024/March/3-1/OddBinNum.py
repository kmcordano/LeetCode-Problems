class Solution:
    def maximumOddBinaryNumber(s: str) -> str:
        result = list(s)
        p0 = -2
        p1 = 0
        first1 = True

        for i in range(len(s)):
            if(s[i] == '1'):
                if first1:
                    result[len(result) - 1] = '1'
                    first1 = False
                else:
                    result[p1] = '1'
                    p1 += 1
            else :
                result[p0] = '0'
                p0 -= 1
        
        return ''.join(result)
    
print(Solution.maximumOddBinaryNumber("0011"))


