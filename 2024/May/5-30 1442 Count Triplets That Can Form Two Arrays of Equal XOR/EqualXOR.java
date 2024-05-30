class Solution {
    public int countTriplets(int[] arr) {
        int[] prefixes = new int[arr.length];
        int val = 0;
        int count = 0;

        for(int i = 0; i < prefixes.length; i++) {
            val ^= arr[i];
            prefixes[i] = val;

            if(val == 0) {
                count += i;
            }
        }

        for(int i = 0; i < arr.length; i++) {
            for(int k = i + 2; k < arr.length; k++) {
                if((prefixes[k] ^ prefixes[i]) == 0) {
                    count += k - i - 1;
                }
            }
        }

        return count;
    }
}