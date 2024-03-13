/**
 * @param {number} n
 * @return {number}
 */
var pivotInteger = function(n) {
    let pLeft = 1;
    let pRight = n;
    let sumLeft = pLeft;
    let sumRight = pRight;

    while(pLeft <= pRight) {
        if(pLeft === pRight) {
            if(sumLeft === sumRight) {
                return pLeft;
            }
        }

        if(sumLeft < sumRight) {
            pLeft++;
            sumLeft += pLeft;
        }
        else {
            pRight--;
            sumRight += pRight;
        }
    }

    return -1;
};