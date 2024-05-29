import java.math.BigInteger;

class Solution {
    public int numSteps(String s) {
        BigInteger val = new BigInteger(s, 2);
        int count = 0;

        while(!val.equals(BigInteger.ONE)) {
            if(val.testBit(0)) {
                val = val.add(BigInteger.ONE);
            }
            else {
                val = val.shiftRight(1);
            }
            count++;
        }

        return count;
    }
}