class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int len = s.length();
        int[] costs = new int[len];
        for(int i = 0; i < len; i++) {
            costs[i] = Math.abs(s.charAt(i) - t.charAt(i));
            System.out.print(costs[i] + " ");
        }

        int left, right = 0;
        int maxLen = 0;
        int subSum = 0;
        for(left = 0; left < len; left++) {
            if(left >= right) {
                right = left;
                subSum = costs[right];
            }

            while(subSum <= maxCost) {
                if(right - left + 1 > maxLen) {
                    maxLen = right - left + 1;
                }
                     
                right++;
                if(right < len) {
                    subSum += costs[right];
                }
                else {
                    break;
                }
            }

            subSum -= costs[left];
        }

        return maxLen;
    }
}