import java.util.HashMap;

public class LongestSubarray {
    public static void main(String[] args) {
        int[] nums = {1,2,2,1,3};
        System.out.println(new Solution().maxSubarrayLength(nums, 1));  
    }
}

class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int front = 0;
        int back = 0;
        HashMap<Integer, Integer> counts = new HashMap<Integer, Integer>();
        int length = 0;
        int max = 0;

        while(back < nums.length && front < nums.length) {
            counts.put(nums[front], counts.getOrDefault(nums[front], 0) + 1);
            if(counts.get(nums[front]) > k) {
                while(back < front && nums[back] != nums[front]) {
                    counts.put(nums[back], counts.get(nums[back]) - 1);
                    back++;
                }
                counts.put(nums[back], counts.get(nums[back]) - 1);
                back++;
            }

            length = front - back + 1;
            if(length > max) {
                max = length;
            }
            front++;
        }

        return max;
    }
}