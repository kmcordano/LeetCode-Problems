import java.util.PriorityQueue;
import java.util.ArrayList;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        PriorityQueue<Integer> starts = new PriorityQueue<Integer>();
        PriorityQueue<Integer> ends = new PriorityQueue<Integer>();
        ArrayList<int[]> result = new ArrayList<int[]>();

        for(int[] interval : intervals) {
            starts.offer(interval[0]);
            ends.offer(interval[1]);
        }
        starts.offer(newInterval[0]);
        ends.offer(newInterval[1]);

        int start;
        int end;
        while(!starts.isEmpty()) {
            start = starts.poll();
            end = ends.poll();

            while(!starts.isEmpty() && end >= starts.peek()) {
                starts.poll();
                end = ends.poll();
            }
            result.add(new int[] {start, end});
        }

        int[][] solution = new int[result.size()][2];
        for(int i = 0; i < result.size(); i++) {
            solution[i] = result.get(i);
        }
        
        return solution;
    }
}