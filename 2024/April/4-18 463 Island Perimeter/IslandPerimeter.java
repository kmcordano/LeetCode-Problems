class Solution {
    public int islandPerimeter(int[][] grid) {
        int gridLength = grid[0].length;
        int gridHeight = grid.length;
        boolean[][] visited = new boolean[gridHeight][gridLength];
        Queue<int[]> toVisit = new LinkedList<int[]>();
        int perimeter = 0;
        int x;
        int y;

        // Find starting point
        STARTING_POINT:
        for(int i = 0; i < gridHeight; i++) {
            for(int j = 0; j < gridLength; j++) {
                if(grid[i][j] == 1) {
                    toVisit.offer(new int[] {j, i});
                    break STARTING_POINT;
                }
            }
        }

        while(!toVisit.isEmpty()) {
            int[] coord = toVisit.poll();
            x = coord[0];
            y = coord[1];

            // Continue if already visited
            if(visited[y][x]) {
               continue;
            }

            // Mark visited
            visited[y][x] = true;

            // Check up
            if(y - 1 >= 0 && grid[y-1][x] == 1) {
                if(!visited[y-1][x]) {
                    toVisit.offer(new int[] {x, y - 1});
                }
            } 
            else {
                perimeter++;
            }

            // Check right
            if(x + 1 < gridLength && grid[y][x+1] == 1) {
                if(!visited[y][x+1]) {
                    toVisit.offer(new int[] {x+1, y});
                }
            }
            else {
                perimeter++;
            }

            // Check down
            if(y + 1 < gridHeight && grid[y+1][x] == 1) {
                if(!visited[y+1][x]) {
                    toVisit.offer(new int[] {x, y+1});
                }
            }
            else {
                perimeter++;
            }

            // Check left 
            if(x - 1 >= 0 && grid[y][x-1] == 1) {
                if(!visited[y][x-1]) {
                    toVisit.offer(new int[] {x-1, y});
                }
            }
            else {
                perimeter++;
            }
        }

        return perimeter;
    }
}