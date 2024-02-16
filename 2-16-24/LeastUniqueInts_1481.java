import java.util.HashMap;
import java.util.Collections;
import java.util.ArrayList;

public class LeastUniqueInts_1481 {
	public static void main(String[] args) {
		int[] nums = {4, 3, 1, 1, 3, 3, 2};
		System.out.println(new Solution().findLeastNumOfUniqueInts(nums, 3));
	}
}

class Solution {
	public int findLeastNumOfUniqueInts(int[] arr, int k) {
		HashMap<Integer, Integer> numCounts = new HashMap<Integer, Integer>();	// Stores the mapping of int values to their count
		ArrayList<Integer> counts;	// ArrayList built from the values in the numCounts map
		int uniqueCount;	// Number of unique values in arr
	
		/* Get count of values in arr */
		for(int i : arr) {
			numCounts.put(i, numCounts.getOrDefault(i, 0) + 1);
		}

		/* Sort count values */
		uniqueCount = numCounts.size();
		counts = new ArrayList<Integer>(uniqueCount);	// Initialize counts with size of unique ints
		numCounts.forEach((num, count) -> { counts.add(count); });	// Store count values into counts
		Collections.sort(counts);	// Sort counts in ascending order for greedy algorithm

		/* Remove k items */
		int dif = 0;
		for(int i = 0; i < counts.size(); i++) {
			dif = k - counts.get(i);
			if(dif >= 0) {	// There are still elements to be removed
				k = dif;
			}
			else {	// More elements have been removed than allowed, meaning the count left is the solution
				break;
			}

			uniqueCount--;	// Move onto next least common element
		}

		return uniqueCount;
	}   
}