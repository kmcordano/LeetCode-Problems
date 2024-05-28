class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int len = s.length();
        int left = 0;
        int right = 0;
        int maxLen = 0;
        int subSum = 0;
        for(right = 0; right < len; right++) {            
            subSum += Math.abs(s.charAt(right) - t.charAt(right));

            while(subSum > maxCost) {
                subSum -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }

            if(right - left + 1 > maxLen) {
                maxLen = right - left + 1;
            } 
        }

        return maxLen;
    }
}