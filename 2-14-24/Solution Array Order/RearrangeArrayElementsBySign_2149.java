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
        int posIndex = 0;
        int negIndex = 0;
        int curIndex = 0;
        int[] solution = new int[nums.length];

        /* Set indexes */
        boolean posFound = false;
        boolean negFound = false;
        for(int i = 0; i < nums.length; i++) {
            if(!posFound && nums[i] >= 0) {
                posIndex = i;
                posFound = true;
            }
            if(!negFound && nums[i] < 0) {
                negIndex = i;
                negFound = true;
            }
            if(posFound && negFound) {
                break;
            }
        }

        /* Populate solution */
        while(curIndex < nums.length) {
            if(curIndex % 2 == 0) {
                solution[curIndex] = nums[posIndex];
                for(int i = posIndex + 1; i < nums.length; i++) {
                    if(nums[i] >= 0) {
                        posIndex = i;
                        break;
                    }
                }
            }
            else {
                solution[curIndex] = nums[negIndex];
                for(int i = negIndex + 1; i < nums.length; i++) {
                    if(nums[i] < 0 ) {
                        negIndex = i;
                        break;
                    }
                }
            }

            curIndex++;
        }

        return solution;
    }
}