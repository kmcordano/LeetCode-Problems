public class MissingNumber {
   public static void main(String[] args) {
      int[] nums = {9,6,4,2,3,5,7,0,1};
      System.out.println(new Solution().missingNumber(nums));
   }
}

class Solution {
    public int missingNumber(int[] nums) {
        int expectedSum = (nums.length * (nums.length + 1))/2;
        int actualSum = 0;
        for(int i : nums) {
            actualSum += i;
        }

        return expectedSum - actualSum;
    }
}