var findLeastNumOfUniqueInts = function(arr, k) {
    /* Get count of values in arr */
    let numCounts = new Map();
    for(let i of arr) {
        numCounts.set(i, (numCounts.get(i) || 0) + 1);
    }

    /* Sort count values */
    let counts = Array.from(numCounts.values());
    let uniqueCount = counts.length;
    counts.sort((a, b) => a - b);

    /* Remove k items */
    let dif = 0;
    for(let i = 0; i < counts.length; i++) {
        dif = k - counts[i];
        if(dif >= 0) {
            k = dif;
        }
        else {
            break;
        }

        uniqueCount--;
    }

    return uniqueCount;
};

const nums = [4, 3, 1, 1, 3, 3, 2];
console.log(findLeastNumOfUniqueInts(nums, 3));