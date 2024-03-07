var missingNumber = function(nums) {
    var expectedSum = (nums.length * (nums.length + 1)) / 2;
    var actualSum = 0;
    for(var i = 0; i < nums.length; i++) {
        actualSum += nums[i];
    }

    return expectedSum - actualSum;
};

const nums = [9,6,4,2,3,5,7,0,1];
console.log(missingNumber(nums));