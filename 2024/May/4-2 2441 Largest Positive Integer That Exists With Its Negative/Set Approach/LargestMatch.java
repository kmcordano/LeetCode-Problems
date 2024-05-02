import java.util.HashSet;

class Solution {
    public int findMaxK(int[] nums) {
        HashSet<Integer> positives = new HashSet<Integer>();
        HashSet<Integer> negatives = new HashSet<Integer>();
        int num = -1;
        
        for(int i : nums) {
            if(i > 0) {
                if(negatives.contains(i)) {
                    if(i > num) {
                        num = i;
                    }
                }
                else {
                    positives.add(i);
                }
            }
            else {
                int pos = Math.abs(i);
                if(positives.contains(pos)) {
                    if(pos > num) {
                        num = pos;
                    }
                }
                else {
                    negatives.add(pos);
                }
            }
        }

        return num;
    }
}