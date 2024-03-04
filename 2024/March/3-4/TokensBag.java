import java.util.Arrays;

public class TokensBag {
    public static void main(String[] args) {
        int[] tokens = {100,200,300,400};
        System.out.println(new Solution().bagOfTokensScore(tokens, 200));
    }
}

class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        int score = 0;
        int maxScore = 0;
        Arrays.sort(tokens);

        if(tokens.length == 0 || power < tokens[0]) {
            return 0;
        }

        int up = 0;
        int down = tokens.length - 1;
        boolean moveMade;
        do {
            moveMade = false;
            while(tokens[up] != -1 && power >= tokens[up]) {
                moveMade = true;
                power -= tokens[up];
                tokens[up] = -1;
                score++;
                up++;
                if(score > maxScore) {
                    maxScore = score;
                }
            }

            if(tokens[down] != -1 && score > 0) {
                moveMade = true;
                power += tokens[down];
                tokens[down] = -1;
                score--;
                down--;
            }
        }
        while(moveMade);

        return maxScore;
    }
}