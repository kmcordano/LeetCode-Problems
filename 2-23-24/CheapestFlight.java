import java.util.LinkedList;
import java.util.Arrays;

public class CheapestFlight {
    public static void main(String[] args) {
        int[][] flights = {{0,1,100},{1,2,100},{1,3,600},{2,0,100},{2,3,200}};
        System.out.println(new Solution().findCheapestPrice(5, flights, 0, 3, 1));
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        LinkedList<int[]> queue = new LinkedList<int[]>();  // [at, cost, stopsRemaining]
        int minCost = Integer.MAX_VALUE;
        int[] cheapestPath = new int[n];
        Arrays.fill(cheapestPath, Integer.MAX_VALUE);
        
        /* Start breadth first search */
        int at = src;
        int currentCost = 0;
        int stopsRemaining = k;
        queue.offer(new int[]{at, currentCost, stopsRemaining});

        while(!queue.isEmpty()) {
            /* Set up current info */
            int[] currentStop = queue.poll();

            at = currentStop[0];
            currentCost = currentStop[1];
            stopsRemaining = currentStop[2];
            if(currentCost < cheapestPath[at]) {
                cheapestPath[at] = currentCost;
            }

            /* Base cases */
            if(at == dst) {
                if(currentCost < minCost) { minCost = currentCost; }
            } 
            else if(stopsRemaining >= 0) {
                for(int[] flight : flights) {
                    if(flight[0] == at && currentCost + flight[2] < cheapestPath[flight[1]]) {
                        queue.offer(new int[] {flight[1], currentCost + flight[2], stopsRemaining - 1});
                    }
                }
            }
        }

        return (minCost == Integer.MAX_VALUE ? -1 : minCost);
    }
}