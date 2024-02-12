import java.util.HashMap;
import java.lang.Math;

public class MajorityElement_169 {
   public static void main(String args[]) {
      Solution sol = new Solution();
      int[] nums = {2,2,1,1,1,2,2,1};
      System.out.println(sol.majorityElement(nums));
   }
}

class Solution {
   public int majorityElement(int[] nums) {
      int maj = (int) Math.floor(nums.length/2.0);
      HashMap map = new HashMap(maj);
      
      int prev = 0;
      for(int i : nums) {
         prev = (int) map.getOrDefault(i, 0);
         map.put(i, prev + 1);
         if(prev >= maj) {
            return i;
         }
      }
      
      return 0; 
   }
}  