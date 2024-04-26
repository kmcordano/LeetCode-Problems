/**
 * @param {number[][]} grid
 * @return {number}
 */
var minFallingPathSum = function(grid) {
    var minExclusive = (row, exclude) => {
        let rowMin = Number.MAX_SAFE_INTEGER;
        for(let i = 0; i < row.length; i++) {
            if(i === exclude) {
                continue;
            }

            if(row[i] < rowMin) {
                rowMin = row[i];
            }
        }
        return rowMin;
    };

    let previous = grid[grid.length - 1];
    for(let i = grid.length - 2; i >= 0; i--) {
        for(let j = 0; j < previous.length; j++) {
            grid[i][j] += minExclusive(previous, j);
        }
        previous = grid[i];
    }

    return minExclusive(previous, -1);
};