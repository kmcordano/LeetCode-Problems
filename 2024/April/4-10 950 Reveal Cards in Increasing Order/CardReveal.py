from typing import List
from typing import Deque

class Solution:
    def deckRevealedIncreasing(self, deck: List[int]) -> List[int]:
        queue = Deque()
        deck.sort()
        deck.reverse()
        
        for num in deck:
            queue.appendleft(num)
            queue.appendleft(queue.pop())

        queue.append(queue.popleft())

        return list(queue)
        
