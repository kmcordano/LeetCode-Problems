class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();

        for(int i = deck.length - 1; i > 0; i--) {
            queue.addFirst(deck[i]);
            queue.addFirst(queue.removeLast());
        }
        queue.addFirst(deck[0]);
        
        for(int i = 0; i < deck.length; i++) {
            deck[i] = queue.poll();
        }

        return deck;
    }
}