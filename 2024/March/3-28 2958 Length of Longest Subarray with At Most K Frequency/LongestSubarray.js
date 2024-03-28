/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var maxSubarrayLength = function(nums, k) {
    var front = 0;
    var back = 0;
    var length = 0;
    var max = 0;
    var counts = new Map();

    while(back < nums.length && front < nums.length) {
        counts.set(nums[front], (counts.get(nums[front]) || 0) + 1);
        if(counts.get(nums[front]) > k) {
            while(back < front && nums[back] != nums[front]) {
                counts.set(nums[back], counts.get(nums[back]) - 1);
                back++;
            }
            counts.set(nums[back], counts.get(nums[back]) - 1);
            back++;
        }
        
        length = front - back + 1;
        if(length > max) {
            max = length;
        }
        front++;
    }

    return max;
};