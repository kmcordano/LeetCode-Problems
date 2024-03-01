import java.util.LinkedList;

public class GCDTraversal {
    public static void main(String[] args) {
        int[] nums = {3,9,5};
        System.out.println(new Solution().canTraverseAllPairs(nums));
    }
}

class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        int numVisited = 0;
        LinkedList<Integer> queue = new LinkedList<Integer>();
        
        queue.offer(0);
        int currentIndex;
        while(!queue.isEmpty()) {
            currentIndex = queue.poll();
            if(!visited[currentIndex]) {
                visited[currentIndex] = true;
                numVisited++;
                if(numVisited >= nums.length) {
                    return true;
                }
            }
            for(int i = 0; i < nums.length; i++) {
                if(!visited[i] && currentIndex != i && isPair(nums[currentIndex], nums[i])) {
                    queue.offer(i);
                }
            }
        }

        if(numVisited >= nums.length) {
            return true;
        }
        return false;
    }

    private boolean isPair(int a, int b) {
        int gcd = (a * b) / lcm(a,b);
        if(gcd > 1) {
            return true;
        }
        else {
            return false;
        }
    }

    private int lcm(int a, int b) {
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