public class FindTheJudge {
    public static void main(String[] args) {
        int[][] input = {{1,3},{2,3}};
        System.out.println(new Solution().findJudge(3, input));
    }
}

class Solution {
    public int findJudge(int n, int[][] trust) {
        boolean[] trustsSomeone = new boolean[n];   // Tracks if person i trusts someone
        int[] trustCount = new int[n];  // Tracks how many people trust person i

        for(int[] trusts : trust) { // Trust relation [i, j]: i trusts j
            trustsSomeone[trusts[0] - 1] = true;    // i trusts someone
            trustCount[trusts[1] - 1] = trustCount[trusts[1] - 1] + 1;  // j is trusted
        }

        for(int i = 0; i < n; i++) {
            if(!trustsSomeone[i] && trustCount[i] == n-1) { // The judge trusts no one and is trusted by all
                return i + 1;
            }
        }

        return -1;
    }
}
