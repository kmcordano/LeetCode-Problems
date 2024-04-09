
class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        int length = tickets.length;
        int val = tickets[k];

        for(int i = 0; i < length; i++) {
            if(i <= k) {
                time += Math.min(tickets[i], val);
            }
            else {
                time += Math.min(tickets[i], val - 1);
            }
        }

        return time;
    }
}