class Solution {
    private int[] deck;
    private int len;

    public boolean isNStraightHand(int[] hand, int groupSize) {
        if(hand.length % groupSize != 0) {
            return false;
        }

        deck = hand;
        len = groupSize;
        Arrays.sort(deck);

        for(int i = 0; i < hand.length; i++) {
            if(deck[i] >= 0) {
                if(!fillGroup(i)) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean fillGroup(int index) {
        int target = deck[index];
        int count = 0;
        for(; index < deck.length; index++) {
            if(deck[index] == target) {
                deck[index] = -1;
                
                target++;
                count++;

                if(count >= len) {
                    return true;
                }
            }
        }

        return false;
    }
}