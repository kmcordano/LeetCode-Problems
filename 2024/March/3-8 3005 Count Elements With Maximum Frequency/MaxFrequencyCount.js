/**
 * @param {number[]} nums
 * @return {number}
 */
var maxFrequencyElements = function(nums) {
    const map = new Map();
    var max = 0;
    
    var newFreq;
    for(var num of nums) {
        newFreq = (map.get(num) || 0) + 1;
        if(newFreq > max) {
            max = newFreq;
        }
        map.set(num, newFreq);
    }
    console.log(map);
    var count = 0;
    for(var freq of map.values()) {
        if(freq === max) {
            count += freq;
        }
    }
    
    return count;
};