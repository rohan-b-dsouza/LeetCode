class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new ArrayDeque<>();
        int ans = -1;
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        while (!queue.isEmpty()) {
            for (int i = 1; i < k; i++) {
                queue.offer(queue.poll());
            }
            ans = queue.poll();
        }
        return ans;
    }
}