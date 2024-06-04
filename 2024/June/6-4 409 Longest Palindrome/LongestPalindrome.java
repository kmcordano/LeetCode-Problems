class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> counts = new HashMap<Character, Integer>();
        int oddCount = 0;

        for(char c : s.toCharArray()) {
            counts.put(c, counts.getOrDefault(c, 0) + 1);
            if(counts.get(c) % 2 == 0) {
                oddCount--;
            }
            else {
                oddCount++;
            }
        }

        if(oddCount > 1) {
            return s.length() - oddCount + 1;
        }
        return s.length();
    }
}