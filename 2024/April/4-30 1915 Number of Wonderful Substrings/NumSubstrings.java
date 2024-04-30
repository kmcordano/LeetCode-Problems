class Solution {
    public long wonderfulSubstrings(String word) {
        int[] prefixCounts = new int[1024];
        long count = 0;
        int prefix = 0;
        prefixCounts[prefix]++;
        for(char c : word.toCharArray()) {
            int shift = c - 'a';
            prefix ^= 1 << shift;
            count += prefixCounts[prefix];
            for(int i = 0; i < 10; i++) {
                count += prefixCounts[prefix ^ (1 << i)];
            }
            prefixCounts[prefix]++;
        }
        return count;
    }
}