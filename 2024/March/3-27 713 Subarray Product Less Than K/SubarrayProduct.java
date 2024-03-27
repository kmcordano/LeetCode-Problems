class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) {
            return 0;
        } 

        int left = 0;
        int right = 0;
        int subSum = 1;
        int count = 0;

        while (right < nums.length) {
            subSum *= nums[right];
            while (subSum >= k) {
                subSum /= nums[left++];
            }
            count += 1 + (right - left);
            right++;
        }

        return count;
    }
}