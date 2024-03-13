class Solution:
    def pivotInteger(self, n: int) -> int:
        pLeft = 1
        pRight = n
        sumLeft = pLeft
        sumRight = pRight

        while pLeft <= pRight:
            if pLeft == pRight:
                if sumLeft == sumRight:
                    return pLeft
        
            if sumLeft < sumRight:
                pLeft += 1
                sumLeft += pLeft
            else:
                pRight -= 1
                sumRight += pRight
        
        return -1