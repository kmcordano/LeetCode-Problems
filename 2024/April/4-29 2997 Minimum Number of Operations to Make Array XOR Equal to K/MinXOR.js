/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var minOperations = function(nums, k) {
    for(let i = nums.length; i >= 0; i--) {
        k = k ^ nums[i];
    }
    return (k.toString(2).match(/1/g) || []).length;
};