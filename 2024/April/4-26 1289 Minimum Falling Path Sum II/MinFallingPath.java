class Solution {
    public int minFallingPathSum(int[][] grid) {
        int[] previous = grid[grid.length - 1];
        for(int i = grid.length - 2; i >= 0; i--) {
            for(int j = 0; j < previous.length; j++) {
                grid[i][j] += minExclusive(previous, j);
            }
            previous = grid[i];
        }

        return minExclusive(previous, -1);
    }

    private int minExclusive(int[] row, int exclude) {
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < row.length; i++) {
            if(i == exclude) {
                continue;
            }

            if(row[i] < min) {
                min = row[i];
            }
        }
        return min;
    }
}