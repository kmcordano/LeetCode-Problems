class Solution {
    public int[] singleNumber(int[] nums) {
        if(nums.length == 2) {
            return nums;
        }

        int xorTotal = 0;
        for(int i : nums) {
            xorTotal ^= i;
        }

        int separator = 1;
        while((xorTotal & separator) == 0) {
            separator = separator << 1;
        }

        int xorGroup1 = 0;
        int xorGroup2 = 0;
        for(int i : nums) {
            if((i & separator) != 0) {
                xorGroup1 ^= i;
            }
            else {
                xorGroup2 ^= i;
            }
        }

        return new int[] {xorGroup1, xorGroup2};
    }
}