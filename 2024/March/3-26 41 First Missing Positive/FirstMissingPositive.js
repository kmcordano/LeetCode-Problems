/**
 * @param {number[]} nums
 * @return {number}
 */
var firstMissingPositive = function(nums) {
    var nextIndex;
    var currentIndex;

    for(var orderIndex = 0; orderIndex < nums.length; orderIndex++) {
        nextIndex = orderIndex;
        if(nums[nextIndex] <= 0) {
            continue;
        }

        nextIndex = nums[nextIndex] - 1;

        while(nextIndex >= 0 && nextIndex < nums.length) {
            currentIndex = nextIndex;
            if(nums[currentIndex] > 0) {
                nextIndex = nums[currentIndex] - 1;
            }
            else {
                nextIndex = -1;
            }
            nums[currentIndex] = currentIndex + 1;

            if(nextIndex === currentIndex) {
                break;
            }
        }
    }
    console.log(nums);
    for(var i = 0; i < nums.length; i++) {
        if(nums[i] != i + 1) {
            return i + 1;
        }
    }

    return nums.length + 1;
};