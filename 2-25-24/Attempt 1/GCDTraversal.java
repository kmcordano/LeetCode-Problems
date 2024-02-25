import java.util.LinkedList;
import java.util.ArrayList;

public class GCDTraversal {
    public static void main(String[] args) {
        int[] nums = {3,9,5};
        System.out.println(new Solution().canTraverseAllPairs(nums));
    }
}

class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        /* Initialize pair array */
        ArrayList<ArrayList<Integer>> connected = new ArrayList<ArrayList<Integer>>();
        for(int i = 0; i < nums.length; i++) {
            connected.add(new ArrayList<Integer>());
        }

        /* Populate pair array */
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(Pair.isPair(nums[i], nums[j])) {
                    connected.get(i).add(j);
                    connected.get(j).add(i);
                }
            }
        }

        /* Trace pair array */
        boolean[] visited = new boolean[nums.length];
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.offer(0);
        int currentIndex;
        
        while(!queue.isEmpty()) {
            currentIndex = queue.poll();
            visited[currentIndex] = true;

            for(int to : connected.get(currentIndex)) {
                if(!visited[to]) {
                    queue.offer(to);
                }
            }
        }

        for(boolean val : visited) {
            if(!val) {
                return false;
            }
        }

        return true;
    }
}

class Pair {
    public static boolean isPair(int a, int b) {
        int gcd = (a * b) / lcm(a,b);
        if(gcd > 1) {
            return true;
        }
        else {
            return false;
        }
    }

    public static int lcm(int a, int b) {
        int i, j;
        int init;
        if(a > b) {
            i = b;
            j = a;
            init = a;
        }
        else {
            i = a;
            j = b;
            init = b;
        }

        while(j % i != 0) {
            j += init;
        }

        return j;
    } 
}