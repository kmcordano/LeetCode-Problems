class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int offset = 0;
        long result = 0;
        int index = happiness.length - 1;
        for(int i = 0; i < k; i++) {
            if(happiness[index] - offset > 0) {
                result += happiness[index] - offset;
            }
            offset++;
            index--;
        }

        return result;
    }
}