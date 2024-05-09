/**
 * @param {number[]} happiness
 * @param {number} k
 * @return {number}
 */
var maximumHappinessSum = function(happiness, k) {
    happiness.sort((a,b) => b - a);
    let offset = 0;
    let result = 0;
    for(let i = 0; i < k; i++) {
        result += happiness[i] - offset > 0
            ? happiness[i] - offset
            : 0
        offset++;
    } 
    return result;
};