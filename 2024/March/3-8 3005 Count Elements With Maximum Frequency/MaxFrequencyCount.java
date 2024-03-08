import java.util.HashMap;

class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
        int max = 0;
        int count = 0;

        int newFreq;
        for(int i : nums) {
            newFreq = map.getOrDefault(i, 0) + 1;
            if(newFreq > max) {
                max = newFreq;
            }
            map.put(i, newFreq);
        }

        for(int i : map.keySet()) {
            if(map.get(i) == max) {
                count += max;
            }
        }

        return count;
    }
}