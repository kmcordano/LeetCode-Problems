import java.util.Arrays;

public class LargestPerimeterPolygon_2971 {
   	public static void main(String[] args) {
		int[] nums = {1, 12, 1, 2, 5, 50, 3};
	  	System.out.print(new Solution().largestPerimeter(nums));
   	}
}

class Solution {
	public long largestPerimeter(int[] nums) {
		Arrays.sort(nums);
		
		long sum = 0;
		long max = -1;
		long cur = 0;
  
		for(int i = 0; i < nums.length; i++) {
			cur = nums[i];
 
			if(sum > cur) {
				max = sum + cur;
			}

			sum += cur;
		}

		return max;
	}
}