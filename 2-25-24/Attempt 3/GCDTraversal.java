import java.util.LinkedList;
import java.util.ArrayList;

public class GCDTraversal {
    public static void main(String[] args) {
        int[] nums = {4,3,12,8};
        System.out.println(new Solution().canTraverseAllPairs(nums));
    }
}

class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        ArrayList<ArrayList<Integer>> factors;
        ArrayList<Integer> includedFactors;
        boolean[] visited;
        LinkedList<Integer> queue;

        /* Find prime factors of all elements in nums */
        factors = new ArrayList<ArrayList<Integer>>(nums.length);
        for(int i = 0; i < nums.length; i++) {
            factors.add(primeFactors(nums[i]));
        }

        includedFactors = new ArrayList<Integer>();
        visited = new boolean[nums.length];
        queue = new LinkedList<Integer>();
        queue.offer(0);
        int currentIndex;
        while(!queue.isEmpty()) {
            /* Get current value */
            currentIndex = queue.poll();
            visited[currentIndex] = true;

            /* Add all factors to included */
            for(int factor : factors.get(currentIndex)) {
                includedFactors.add(factor);
            }

            /* Queue next index with included factors */
            for(int i = 0; i < nums.length; i++) {
                if(i != currentIndex) {
                    for(int nextFactor : factors.get(i)) {
                        if(includedFactors.contains(nextFactor)) {
                            if(!visited[i]) {
                                queue.offer(i);
                            }
                            break;
                        }
                    }
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

    private ArrayList<Integer> primeFactors(int num) {
        ArrayList<Integer> factors = new ArrayList<Integer>();

        if(num % 2 == 0) {
            factors.add(num);
            while (num % 2 == 0) {
                num /= 2;
            }
        }
    
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if(num % i == 0) {
                factors.add(i);
                while (num % i == 0) {
                    num /= i;
                }
            }
        }
     
        if (num > 2) {
            factors.add(num);
        }

        return factors;
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