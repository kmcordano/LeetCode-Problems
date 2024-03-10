/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
var intersection = function(nums1, nums2) {
    /*  
     *  Intersection implemented with filter
     *  Arrow function takes a num and index value from nums1
     *  If the num is included in nums2 and the index matches 
     *    indexOf (will be true only if unique), num is filtered
     */
    return nums1.filter((num, index) => nums2.includes(num) && nums1.indexOf(num) === index);
};