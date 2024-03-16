/**
 * @param {number[]} nums
 * @return {number}
 */
var findMaxLength = function(nums) {
    let sums = Array(nums.length);
    let acc = 0;
    let firstInstance = new Map();
    let maxZero = -1;
    let maxInterval = 0;

    for(let i = 0; i < nums.length; i++) {
        if(nums[i] === 0) {
            acc--;
        }
        else {
            acc++;
        }

        if(acc === 0) {
            maxZero = i;
        }
        else {
            if(!firstInstance.has(acc)) {
                firstInstance.set(acc, i);
            }
            else {
                if(i - firstInstance.get(acc) > maxInterval) {
                    maxInterval = i - firstInstance.get(acc);
                }
            }
        }

        sums[i] = acc;
    }

    if(maxZero > maxInterval) {
        return maxZero + 1;
    }

    return maxInterval;
};