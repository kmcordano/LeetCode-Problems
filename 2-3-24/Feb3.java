import java.util.Stack;
import java.util.Collections;
import java.util.ArrayList;

public class Feb3 {
   public static void main(String args[]) {
      Solution sol = new Solution();
      int[] input = {1, 15, 7, 9, 2, 5, 10};
      System.out.println(sol.maxSumAfterPartitioning(input, 3));
   }
}

class Solution {
   public int maxSumAfterPartitioning(int[] arr, int k) {
      /* Create stack of decreasing vals */
      Stack<Integer> nums = new Stack<Integer>();
      for(int i : arr) {
         nums.push(Integer.valueOf(i));
      }
      Collections.sort(nums);

      /* Initialize solution array */
      int[] solution = new int[arr.length];
      for(int i = 0; i < arr.length; ++i) {
         solution[i] = -1;
      }

      /* Work through nums stack */
      int temp = -1;
      int index = -1;
      while(!nums.isEmpty()){
         temp = nums.pop().intValue();
         index = indexOf(arr, temp);

         solution[index] = temp;
         arr[index] = -1;

         solution = fillBucket(arr, index, k);
      }
      /* Pop largest value into temp */

      /* Locate in arr, set sol to temp, set arr to -1 */

      /* Find min bucket, set all to temp */

      /* Repeat */

      return 0;
   }

   private int[] fillBucket(int[] arr, int index, int k) {
      return new int[0];
   }

   private int indexOf(int[] arr, int val) {
      for(int i = 0; i < arr.length; ++i) {
         if(arr[i] == val) {
            return i;
         }
      }

      return -1;
   }
}