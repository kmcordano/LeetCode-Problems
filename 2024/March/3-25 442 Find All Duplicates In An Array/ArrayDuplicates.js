/**
 * @param {number[]} nums
 * @return {number[]}
 */
var findDuplicates = function(nums) {
    var result = Array();
    var index;

    for(var num of nums) {
        index = Math.abs(num) - 1;
        if(nums[index] < 0) {
            result.push(Math.abs(num));
        }
        else {
            nums[index] = -nums[index];
        }
    }

    return result;
};