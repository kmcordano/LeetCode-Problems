public class SortedArraySquares {
    public static void main(String[] args) {
        int[] nums = {-7, -3, 2, 3, 11};
        int[] sol = new Solution().sortedSquares(nums);

        for(int i: sol) {
            System.out.print(i + " ");
        }
    }
}

class Solution {
    public int[] sortedSquares(int[] nums) {
        /* Base case */
        if(nums.length == 1) {  
            return new int[] { nums[0] * nums[0]};
        }

        /* Variables */
        int positiveIndex = 0;
        int negativeIndex;
        int[] sorted = new int[nums.length];
        int sortedIndex = 0;

        /* Find the positive/negative point */
        while(positiveIndex < nums.length && nums[positiveIndex] < 0) { 
            positiveIndex++;
        }
        negativeIndex = positiveIndex - 1;

        /* Insert into solution array in order */
        int positiveSquare;
        int negativeSquare;
        while(negativeIndex >= 0 && positiveIndex < nums.length) {  // Move pointers outwards until bounds of num
            positiveSquare = nums[positiveIndex] * nums[positiveIndex];
            negativeSquare = nums[negativeIndex] * nums[negativeIndex];

            if(positiveSquare < negativeSquare) {
                sorted[sortedIndex++] = positiveSquare;
                positiveIndex++;
            } else {
                sorted[sortedIndex++] = negativeSquare;
                negativeIndex--;
            }
        }

        /* Complete nums traversal */
        while(negativeIndex >= 0) {
            sorted[sortedIndex++] = nums[negativeIndex] * nums[negativeIndex];
            negativeIndex--;
        }

        while(positiveIndex < nums.length) {
            sorted[sortedIndex++] = nums[positiveIndex] * nums[positiveIndex];
            positiveIndex++;
        }

        return sorted;
    }
}