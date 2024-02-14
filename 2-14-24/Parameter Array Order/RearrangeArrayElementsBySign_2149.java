public class RearrangeArrayElementsBySign_2149 {
   public static void main(String args[]) {
      int[] nums = {3, 1, -2, -5, 2, -4};
      for(int i : new Solution().rearrangeArray(nums)) {
         System.out.print(i + " ");
      }  
   }
}

class Solution {
   public int[] rearrangeArray(int[] nums) {
      /* Initialize variables */
      int[] solution = new int[nums.length];
      int posIndex = 0;
      int negIndex = 1;
      
      /* Iterate through nums */
      for(int i : nums) {
         if(i > 0) {   // If current num is positive, place into next pos index
            solution[posIndex] = i;
            posIndex += 2;
         }
         else {   // If current num is negative, place into next neg index
            solution[negIndex] = i;
            negIndex += 2;
         }
      }  
   

      return solution;
   }
}