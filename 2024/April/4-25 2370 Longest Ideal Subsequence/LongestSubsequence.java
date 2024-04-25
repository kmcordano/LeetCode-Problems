class Solution {
    public int longestIdealString(String s, int k) {
        int[] seqLength = new int[26];
        int maxLength = 1;
        for(int i = 0; i < s.length(); i++){
            int c = s.charAt(i) - 'a';
            for(int j = c; j >= 0 && j >= c - k; j--){
                seqLength[c] = Math.max(seqLength[c], seqLength[j] + 1);
            }
            for(int j = c + 1; j < 26 && j <= c + k; j++){
                seqLength[c] = Math.max(seqLength[c], seqLength[j] + 1);
            }
            maxLength = Math.max(maxLength, seqLength[c]);
        }
        
        return maxLength;
    }
}