/**
 * @param {character[][]} board
 * @param {string} word
 * @return {boolean}
 */
var exist = function(board, word) {
    let current = 0;
    let visited = new Array(board.length);
    for(let i = 0; i < visited.length; i++) {
        visited[i] = new Array(board[0].length);
    }

    var search = (i, j, word) => {
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

        if(word.length == 1) {
            return true;
        }

        visited[i][j] = current;
        let nextWord = word.substring(1);

        let res = search(i-1, j, nextWord)
                   || search(i, j-1, nextWord)
                   || search(i+1, j, nextWord)
                   || search(i, j+1, nextWord); 
        if(res == false) {
            visited[i][j] = current - 1;
        }

        return res;
    }


    for(let i = 0; i < board.length; i++) {
        for(let j = 0; j < board[0].length; j++) {
            current++;
            if(search(i, j, word)) {
                return true;
            }
        }
    }

    return false;
};