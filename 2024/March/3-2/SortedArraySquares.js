const sortedSquares = function(nums) {
    if(nums.length === 1) {
        return [nums[0] * nums[0]];
    }

    var posI = 0;
    const sorted = new Array(nums.length);
    var sortedIndex = 0;

    while(posI < nums.length && nums[posI] < 0) {
        posI++;
    }
    var negI = posI - 1;

    while(negI >= 0 && posI < nums.length) {
        var posSqr = nums[posI] * nums[posI];
        var negSqr = nums[negI] * nums[negI];

        if(posSqr < negSqr) {
            sorted[sortedIndex] = posSqr;
            posI++;
            sortedIndex++;
        }
        else {
            sorted[sortedIndex] = negSqr;
            negI--;
            sortedIndex++;
        }
    }

    while(negI >= 0) {
        sorted[sortedIndex] = nums[negI] * nums[negI];
        negI--;
        sortedIndex++;
    }

    while(posI < nums.length) {
        sorted[sortedIndex] = nums[posI] * nums[posI];
        posI++;
        sortedIndex++;
    }

    return sorted;
};

const nums = [-7,-3,2,3,11];
console.log(sortedSquares(nums));