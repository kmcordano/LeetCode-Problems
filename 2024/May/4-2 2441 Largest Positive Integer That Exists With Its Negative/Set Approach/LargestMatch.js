/**
 * @param {number[]} nums
 * @return {number}
 */
var findMaxK = function(nums) {
    let positives = new Set();
    let negatives = new Set();
    let num = -1;

    for(let i of nums) {
        if(i > 0) {
            if(negatives.has(i)) {
                if(i > num) {
                    num = i;
                }
            }
            else {
                positives.add(i);
            }
        }
        else {
            let pos = Math.abs(i);
            if(positives.has(pos)) {
                if(pos > num) {
                    num = pos;
                }
            }
            else {
                negatives.add(pos);
            }
        }
    }

    return num;
};