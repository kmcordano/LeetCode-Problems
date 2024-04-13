/**
 * @param {character[][]} matrix
 * @return {number}
 */
var maximalRectangle = function(matrix) {
    let scanned = new Array(matrix[0].length);
    for(let i = 0; i < scanned.length; i++) {
        scanned[i] = 0;
    }
    let scannedMax = 0;
    let max = 0;

    for(let row of matrix) {
        for(let i = 0; i < row.length; i++) {
            if(row[i] === '0') {
                scanned[i] = 0;
            }
            else {
                scanned[i] += 1;
            }
        }

        scannedMax = findMax(scanned);
        console.log(scanned);
        console.log(scannedMax);
        if(scannedMax > max) {
            max = scannedMax;
        }
    }

    return max;
};

let findMax = (row) => {
    let maxRow = 0;
    let curVal;
    let iterMax;

    for(let i = 0; i < row.length; i++) {
        if(row[i] === 0) {
            continue;
        }

        curVal = row[i];
        iterMax = curVal;
        for(let left = i - 1; left >= 0; left--) {
            if(row[left] === 0 || row[left] < curVal) {
                break;
            }
            else {
                iterMax += curVal;
            }
        }
        for(let right = i + 1; right < row.length; right++) {
            if(row[right] === 0 || row[right] < curVal) {
                break;
            }
            else {
                iterMax += curVal;
            }
        }

        if(iterMax > maxRow) {
            maxRow = iterMax;
        }
    }

    return maxRow;
};
