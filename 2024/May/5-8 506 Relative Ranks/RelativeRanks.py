from typing import List

class Solution:
    def findRelativeRanks(self, score: List[int]) -> List[str]:
        indexes = {}
        answer = [''] * len(score)

        for i, val in enumerate(score):
            indexes[val] = i
        
        score.sort(reverse=True)
        place = 1
        for s in score:
            string = ''
            if place == 1:
                string = 'Gold Medal'
            elif place == 2:
                string = 'Silver Medal'
            elif place == 3:
                string = 'Bronze Medal'
            else:
                string = str(place)
            
            answer[indexes[s]] = string
            place += 1
        
        return answer