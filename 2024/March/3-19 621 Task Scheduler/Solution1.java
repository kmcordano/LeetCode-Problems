import java.util.PriorityQueue;
import java.util.HashMap;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Integer> schedule = new PriorityQueue<Integer>();
        HashMap<Character, Integer> wait = new HashMap<Character, Integer>();

        for(char task : tasks) {
            schedule.offer(wait.getOrDefault(task, 0));
            wait.put(task, wait.getOrDefault(task, 0) + n + 1);
        }

        int time = 0;
        int nextTime = 0;
        while(!schedule.isEmpty()) {
            nextTime = schedule.poll();
            if(nextTime > time) {
                time = nextTime;
            }
            time++;
        }

        return time;
    }
}