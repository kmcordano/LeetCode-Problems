class Solution {
    private long[][][] memory;
    private final long MOD = 1000000007;

    public int checkRecord(int n) {
        this.memory = new long[n+1][2][3];

        return (int) (dp(n, 0, 0) % MOD);
    }

    private long dp(int len, int abs, int late) {
        if(len == 0) {
            return 1;
        }

        if(memory[len][abs][late] != 0) {
            return memory[len][abs][late];
        }

        long count = 0;
        count += dp(len-1, abs, 0);
        if(abs < 1) {
            count += dp(len-1, abs+1, 0);
        }
        if(late < 2) {
            count += dp(len-1, abs, late+1);
        }
        memory[len][abs][late] = count % MOD;

        return count;
    }
}