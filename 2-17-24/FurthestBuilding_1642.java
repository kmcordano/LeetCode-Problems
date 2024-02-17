import java.util.PriorityQueue;
import java.util.Collections;

public class FurthestBuilding_1642 {
    public static void main(String[] args) {
        int[] heights = {4, 2, 7, 6, 9, 14, 12};
        System.out.println(new Solution().furthestBuilding(heights, 5, 1));
    }
}

class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        // Quick base case
        if(ladders > heights.length -1) {
            return heights.length -1;
        }

        int collectiveDif = 0;
        int currentDif = 0;
        int laddersLeft = ladders;
        PriorityQueue<Integer> jumps = new PriorityQueue<Integer>(Collections.reverseOrder());

        /* Iterate through heights */
        for(int i = 0; i < heights.length - 1; i++) {
            currentDif = heights[i+1] - heights[i];
            if(currentDif > 0) {
                jumps.add(currentDif);  // Track the jumps and sort descending
                collectiveDif += currentDif;    // Track collective difference
                if(collectiveDif > bricks) {    // If there aren't enough bricks, ladders can remove largest jump
                    if(laddersLeft <= 0) {  // If no ladders are left, no more progess can be made
                        return i;
                    }
                    collectiveDif -= jumps.poll();  // Replace the largest jump with a ladder
                    laddersLeft--;
                }
            }
        }

        return heights.length - 1;  // All buildings were able to be traversed
    }
}