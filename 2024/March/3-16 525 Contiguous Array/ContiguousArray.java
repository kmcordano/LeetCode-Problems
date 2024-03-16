import java.util.HashMap;

class Solution {
    public int findMaxLength(int[] nums) {
        int[] sums = new int[nums.length];
        int acc = 0;
        HashMap<Integer, Integer> firstInstance = new HashMap<Integer, Integer>();
        int maxZero = -1;
        int maxInterval = 0;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                acc--;
            }
            else {
                acc++;
            }

            if(acc == 0) {
                maxZero = i;
            }
            else {
                if(!firstInstance.containsKey(acc)) {
                    firstInstance.put(acc, i);
                }
                else {
                    if(i - firstInstance.get(acc) > maxInterval) {
                        maxInterval = i - firstInstance.get(acc);
                    }
                }
            }

            sums[i] = acc;
        }

        if(maxZero > maxInterval) {
            return maxZero + 1;
        }

        return maxInterval;
    }
}