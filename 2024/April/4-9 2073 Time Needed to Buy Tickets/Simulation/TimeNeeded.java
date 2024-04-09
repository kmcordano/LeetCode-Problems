class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        int p = 0;
        int length = tickets.length;

        while(tickets[k] > 0) {
            if(tickets[p] > 0) {
                tickets[p] = tickets[p] - 1;
                time++;            
            }

            p++;
            p = p % length;
        }

        return time;
    }
}