import java.util.HashMap;

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer, Integer> prefixToSum = new HashMap<Integer, Integer>();
        HashMap<Integer, Integer> sumToCount = new HashMap<Integer, Integer>();
        int sum = 0;
        int count = 0;

        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            prefixToSum.put(i, sum);
        }

        for(int s : prefixToSum.values()) {
            sumToCount.put(s, sumToCount.getOrDefault(s, 0) + 1);
        }

        for(int s : prefixToSum.values()) {
            count += sumToCount.getOrDefault(s + goal, 0);
            if(s == goal) {
                count++;
            }
        }

        /* This requires a different approach for goal = 0 */
        if(goal != 0) {
            return count;
        }

        count = sumNums(sumToCount.getOrDefault(0, -1));
 
        for(int s: sumToCount.keySet()) {
            if(s == 0) {
                continue;
            }
            else {
                count += sumNums(sumToCount.get(s) - 1);
            }
        }

        return count;
    }

    private int sumNums(int n) {
        return (n * (n+1)) / 2;
    }
}