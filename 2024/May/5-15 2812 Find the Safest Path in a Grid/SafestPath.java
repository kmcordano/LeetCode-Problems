import java.util.Queue;

class Solution {
    private int[][] mhtDist;

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        mhtDist = new int[grid.size()][grid.get(0).size()];
        for(int[] row : mhtDist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        for(int row = 0; row < mhtDist.length; row++) {
            for(int col = 0; col < mhtDist[0].length; col++) {
                if(grid.get(row).get(col) == 1) {
                    bfs(row, col);
                }
            }
        }

        int min = 0;
        while(bfsPath(min)) {
            min++;
        }
        return min;
    }

    private boolean bfsPath(int min) {
        boolean[][] visited = new boolean[mhtDist.length][mhtDist[0].length];
        Queue<int[]> toVisit = new ArrayDeque<int[]>();
        if(mhtDist[0][0] == min) {
            return false;
        }

        toVisit.offer(new int[] {0, 0});

        int[] at;
        while(!toVisit.isEmpty()) {
            at = toVisit.poll();
            if(visited[at[0]][at[1]]) {
                continue;
            }
            visited[at[0]][at[1]] = true;

            if(at[0] - 1 >= 0) {
                if(!visited[at[0]-1][at[1]] 
                && mhtDist[at[0]-1][at[1]] > min) {
                    toVisit.offer(new int[] {at[0]-1, at[1]});
                }
            }

            if(at[1] + 1 < mhtDist[0].length) {
                if(!visited[at[0]][at[1]+1] 
                && mhtDist[at[0]][at[1]+1] > min) {
                    toVisit.offer(new int[] {at[0], at[1]+1});
                }
            }

            if(at[0] + 1 < mhtDist.length) {
                if(!visited[at[0]+1][at[1]]
                && mhtDist[at[0]+1][at[1]] > min) {
                    toVisit.offer(new int[] {at[0]+1, at[1]});
                }
            }

            if(at[1] - 1 >= 0) {
                if(!visited[at[0]][at[1]-1]
                && mhtDist[at[0]][at[1]-1] > min) {
                    toVisit.offer(new int[] {at[0], at[1]-1});
                }
            }
        }

        return visited[mhtDist.length - 1][mhtDist[0].length - 1];
    }

    private void bfs(int row, int col) {
        Queue<int[]> toVisit = new ArrayDeque<int[]>();
        toVisit.offer(new int[] {row, col, 0});

        int[] at;
        while(!toVisit.isEmpty()) {
            at = toVisit.poll();

            mhtDist[at[0]][at[1]] = at[2];

            // top
            if(at[0] - 1 >= 0) {
                if(at[2] + 1 < mhtDist[at[0] - 1][at[1]]) {
                    toVisit.offer(new int[] {at[0] - 1, at[1], at[2] + 1});
                }
            }
            
            // right
            if(at[1] + 1 < mhtDist[0].length) {
                if(at[2] + 1 < mhtDist[at[0]][at[1] + 1]) {
                    toVisit.offer(new int[] {at[0], at[1] + 1, at[2] + 1});
                }
            }

            // down
            if(at[0] + 1 < mhtDist.length) {
                if(at[2] + 1 < mhtDist[at[0] + 1][at[1]]) {
                    toVisit.offer(new int[] {at[0] + 1, at[1], at[2] + 1});
                }
            }

            // left
            if(at[1] - 1 >= 0) {
                if(at[2] + 1 < mhtDist[at[0]][at[1] - 1]) {
                    toVisit.offer(new int[] {at[0], at[1] - 1, at[2] + 1});
                }
            }
        }
    }
}