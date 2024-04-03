class Solution {
    int[][] visited;
    char[][] board;
    int current;

    public boolean exist(char[][] board, String word) {
        visited = new int[board.length][board[0].length];
        this.board = board;
        current = 0;

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                current++;
                if(search(i, j, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean search(int i, int j, String word) {
        if(i < 0
        || i >= visited.length
        || j < 0
        || j >= visited[0].length) {
            return false;
        }

        if(board[i][j] != word.charAt(0)) {
            return false;
        }

        if(visited[i][j] == current) {
            return false;
        }

        if(word.length() == 1) {
            return true;
        }

        visited[i][j] = current;
        String nextWord = word.substring(1);

        boolean res = search(i-1, j, nextWord)
                   || search(i, j-1, nextWord)
                   || search(i+1, j, nextWord)
                   || search(i, j+1, nextWord); 
        if(res == false) {
            visited[i][j] = current - 1;
        }

        return res;
    }
}