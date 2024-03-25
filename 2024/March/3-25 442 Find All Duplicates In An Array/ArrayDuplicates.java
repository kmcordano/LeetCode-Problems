import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        int index;
        for(int num : nums) {
            index = Math.abs(num) - 1;
            if(nums[index] < 0) {
                result.add(Math.abs(num));
            }
            else {
                nums[index] = -nums[index];
            }
        }

        return result;
    }
}