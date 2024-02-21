public class BitwiseAnd {
    public static void main(String[] args) {
        System.out.println(new Solution().rangeBitwiseAnd(2147483646,2147483647));
    }
}

class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        /* 2^k+1 > left > 2^k and 2^k+1 > right > 2^k */
        /*  left and right must have the same prefix  */
        if((31 - Integer.numberOfLeadingZeros(left)) != (31 - Integer.numberOfLeadingZeros(right))) {
            return 0;
        }
        
        /* Remove rightost significant bit until equal */
        while(right > left) {
            right = right & (right - 1);
        }
        while(left != right) {
            left = left & (left - 1);
        }

        /* All numbers between will have this shared prefix */
        return left;
    }
}