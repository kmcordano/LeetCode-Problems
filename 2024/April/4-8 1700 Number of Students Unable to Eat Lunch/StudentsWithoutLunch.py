from typing import List

class Solution:
    def countStudents(self, students: List[int], sandwiches: List[int]) -> int:
        num0 = 0
        num1 = 0

        for s in students:
            if s == 0:
                num0 += 1
            else:
                num1 += 1
        
        for s in sandwiches:
            if s == 0:
                num0 -= 1
                if num0 < 0:
                    return num1
            else:
                num1 -= 1
                if num1 < 0:
                    return num0
        
        return 0