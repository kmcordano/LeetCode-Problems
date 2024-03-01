import java.util.HashMap;

public class MajorityElement {
   public static void main(String args[]) {
      Solution sol = new Solution();
      int[] nums = {2,2,1,1,1,2,2,1,1,1};
      System.out.println(sol.majorityElement(nums));
   }
}

class Solution {
   public int majorityElement(int[] nums) {
      int maj = nums.length / 2;
      HashMap map = new HashMap(maj);
      
      int prev = 0;
      for(int i : nums) {
         prev = (int) map.getOrDefault(i, 0);
         map.put(i, prev + 1);
         if(prev + 1 >= maj) {
            return i;
         }
      }
      
      return 0; 
   }
}  