class Solution {
    public int findMaxK(int[] nums) {
        Queue<Integer> negatives = new PriorityQueue<Integer>((a,b) -> b - a);
        Queue<Integer> positives = new PriorityQueue<Integer>((a,b) -> b - a);
        
        for(int i : nums) {
            if(i < 0) {
                negatives.offer(Math.abs(i));
            }
            else {
                positives.offer(Math.abs(i));
            }
        }

        while(!positives.isEmpty() && !negatives.isEmpty()) {
            if(Integer.compare(positives.peek(), negatives.peek()) == 0) {
                return positives.poll();
            }
            
            if(Integer.compare(positives.peek(), negatives.peek()) > 0) {
                positives.poll();
            }
            else {
                negatives.poll();
            }
        }

        return -1;
    }
}