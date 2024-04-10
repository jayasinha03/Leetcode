class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Deque<Integer> result = new LinkedList<>();
        for (int i = deck.length - 1; i >= 0; i--) {
            if (!result.isEmpty()) {
                result.addFirst(result.removeLast());
            }
            result.addFirst(deck[i]);
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}