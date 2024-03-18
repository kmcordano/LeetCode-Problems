import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> { return a[1] - b[1]; });
        
        int currentPairPointer = 0;
        int x = points[currentPairPointer][1];
        int arrowsThrown = 1;

        while(currentPairPointer < points.length) {
            if(x >= points[currentPairPointer][0] && x <= points[currentPairPointer][1]) {
                currentPairPointer++;
            }
            else {
                arrowsThrown++;
                x = points[currentPairPointer][1];
            }
        }


        return arrowsThrown;
    }
}