import java.util.HashSet;

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<Integer>();  // Set of unique items from nums1
        HashSet<Integer> result = new HashSet<Integer>();   // Unique intersection

        // Create set from nums1
        for(int i : nums1) {
            set.add(i);
        }
        
        // Find intersection
        for(int i : nums2) {
            if(set.contains(i)) {
                result.add(i);
            }
        }
        
        // Convert to return value
        int[] arr = new int[result.size()];
        int index = 0;
        for(int i : result) {
            arr[index++] = i;
        }

        return arr;
    }
}