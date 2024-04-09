from typing import List

class Solution:
    def timeRequiredToBuy(self, tickets: List[int], k: int) -> int:
        time = 0
        p = 0
        length = len(tickets)

        while tickets[k] > 0:
            if tickets[p] > 0:
                tickets[p] = tickets[p] - 1
                time += 1
            
            p += 1
            p = p % length
        
        return time