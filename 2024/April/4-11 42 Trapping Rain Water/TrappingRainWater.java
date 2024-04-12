class Solution {
    public int trap(int[] height) {
        ArrayList<int[]> pools = new ArrayList<int[]>();
        int left, right, nextHighest;
        boolean validPool;

        for(int p = 0; p < height.length; p++) {
            left = p;
            right = p;
            nextHighest = 0;
            validPool = false;

            for(int i = p + 1; i < height.length; i++) {
                if(height[i] >= nextHighest) {
                    right = i;
                    nextHighest = height[i];
                    validPool = true;
                }
                
                if(height[i] >= height[left]) {
                    break;
                }
            }

            if(validPool) {
                pools.add(new int[] {left, right});
                p = right - 1;
            }
        }

        int waterSum = 0;
        int level;
        for(int[] pool : pools) {
            level = Math.min(height[pool[0]], height[pool[1]]);
            for(int i = pool[0] + 1; i < pool[1]; i++) {
                waterSum += level - height[i];
            }
        }

        return waterSum;
    }
}