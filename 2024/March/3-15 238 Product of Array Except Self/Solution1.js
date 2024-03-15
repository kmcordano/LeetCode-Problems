/**
 * @param {number[]} nums
 * @return {number[]}
 */
var productExceptSelf = function(nums) {
    let prefix = Array(nums.length);
    let suffix = Array(nums.length);

    let product = 1;
    for(let i = 0; i < nums.length; i++) {
        prefix[i] = product;
        product *= nums[i];
    }

    product = 1;
    for(let i = nums.length - 1; i >= 0; i--) {
        suffix[i] = product;
        product *= nums[i];
    }


    let result = Array(nums.length);
    for(let i = 0; i < nums.length; i++) {
        result[i] = prefix[i] * suffix[i];
    }
    return result;
};