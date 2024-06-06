class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) {
            return false;
        }

        PriorityQueue<Integer> deck = new PriorityQueue<Integer>();
        for(int card : hand) {
            deck.offer(card);
        }

        while(!deck.isEmpty()) {
            int target = deck.peek();
            for(int i = 0; i < groupSize; i++) {
                if(!deck.remove(target)) {
                    return false;
                }
                target++;
            }
        }

        return true;
    }
}