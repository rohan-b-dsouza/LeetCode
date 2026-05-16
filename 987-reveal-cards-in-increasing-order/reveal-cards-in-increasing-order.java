class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length; 
        Queue<Integer> queue = new ArrayDeque<>();
        Arrays.sort(deck);
        for (int i = 0; i <= n - 1; i++) {
            queue.offer(i);
        }
        int[] ans = new int[n];
        int j = 0;
        while (!queue.isEmpty()) {
            ans[queue.poll()] = deck[j++];
            if (!queue.isEmpty()) queue.offer(queue.poll()); 
        }
        return ans;
    }
}