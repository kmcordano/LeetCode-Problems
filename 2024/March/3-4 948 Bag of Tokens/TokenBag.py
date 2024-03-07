from typing import List

class Solution:
    def bagOfTokensScore(tokens: List[int], power: int) -> int:
        score = 0
        maxScore = 0
        tokens.sort()
        if len(tokens) == 0 or power < tokens[0]:
            return 0
        up = 0
        down = len(tokens) - 1
        moveMade = True

        while moveMade:
            moveMade = False
            while up < len(tokens) and tokens[up] != -1 and power >= tokens[up]:
                moveMade = True
                power -= tokens[up]
                tokens[up] = -1
                score += 1
                up += 1
                if score > maxScore:
                    maxScore = score

            if down >= 0 and tokens[down] != -1 and score > 0:
                moveMade = True
                power += tokens[down]
                tokens[down] = -1
                score -= 1
                down -= 1

        return maxScore