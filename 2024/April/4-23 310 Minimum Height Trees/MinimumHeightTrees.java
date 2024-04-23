import java.util.*;

public class MinimumHeightTrees {
   public static void main(String[] args) {
      int[][] edges = {{1,0},{1,2},{1,3}};
      System.out.println(new Solution().findMinHeightTrees(4, edges));
   }
}

class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        ArrayList<Integer> solutions = new ArrayList<Integer>();
        if(n == 1) {
            solutions.add(0);
            return solutions;
        }

        int[] connections = new int[n];
        HashMap<Integer, ArrayList<Integer>> edgeMap = new HashMap<Integer, ArrayList<Integer>>();
        for(int[] edge : edges) {
            connections[edge[0]]++;
            connections[edge[1]]++;
            
            edgeMap.computeIfAbsent(edge[0], a -> new ArrayList<Integer>()).add(edge[1]);
            edgeMap.computeIfAbsent(edge[1], a -> new ArrayList<Integer>()).add(edge[0]);
        }

        Queue<Integer> toRemove = new ArrayDeque<Integer>();
        for(int i = 0; i < n; i++) {
            if(connections[i] == 1) {
                toRemove.add(i);
            }
        }

        int numRemoved = 0;
        while(n - numRemoved > 2) {
            int size = toRemove.size();
            numRemoved += size;
            for(int i = 0; i < size; i++) {
                int node = toRemove.poll();
                for(int edge : edgeMap.getOrDefault(node, new ArrayList<Integer>())) {
                    if(--connections[edge] == 1) {
                        toRemove.add(edge);
                    }
                }
            }
        }

        solutions.addAll(toRemove);
        return solutions;
    }
}