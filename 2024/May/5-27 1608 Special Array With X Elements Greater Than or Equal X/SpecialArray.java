class Solution {
    public int specialArray(int[] nums) {
        int result = nums.length;
        int index = 0;
        
        Arrays.sort(nums);

        while(index < nums.length) {
            if(nums[index] >= result) {
                if(index - 1 >= 0 && nums[index - 1] >= result) {
                    return -1;
                }
                else {
                    return result;
                }
            }

            index++;
            result--;
        }

        return -1;
    }
}