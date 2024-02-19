public class PowerOfTwo {
    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfTwo(8));
    }
}

class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) {
            return false;
        }
        
        return ((n & n-1) == 0);
    }
}
