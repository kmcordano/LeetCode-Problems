class Solution {
    public int minOperations(int[] nums, int k) {
        for(int i = nums.length - 1; i >= 0; i--) {
            k = k ^ nums[i];
        }
        return Integer.bitCount(k);
    }
}