class Solution {
    public int matrixScore(int[][] grid) {
        for(int[] row : grid) {
            if(row[0] != 1) {
                for(int i = 0; i < row.length; i++) {
                    row[i] = row[i] ^ 1;
                }
            }
        }

        for(int i = 0; i < grid[0].length; i++) {
            int num0s = 0;
            for(int[] row : grid) {
                if(row[i] == 0) {
                    num0s++;
                }
            }
            if(num0s > grid.length / 2) {
                for(int[] row : grid) {
                    row[i] = row[i] ^ 1;
                }
            }
        }

        int score = 0;
        for(int[] row : grid) {
            int factor = 1;
            for(int i = row.length - 1; i >= 0; i--) {
                score += row[i] * factor;
                factor = factor << 1;
            }
        }

        return score;
    }
}