class Solution {
    public boolean isValid(int x, int n) {
        return x >= 0 && x < n;
    }

    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return Integer.compare(a[0], b[0]);
        });
        pq.offer(new int[] { grid[0][0], 0, 0 });
        visited[0][0] = true;
        int ans = 0;
        while (!pq.isEmpty()) {
            int[] peak = pq.poll();
            int time = peak[0];
            int u = peak[1];
            int v = peak[2];
            ans = Math.max(ans, time);
            if (u == n - 1 && v == n - 1)
                return ans;
            if (isValid(u - 1, n) && !visited[u - 1][v]) {
                pq.offer(new int[] { grid[u - 1][v], u - 1, v });
                visited[u - 1][v] = true;
            }
            if (isValid(u + 1, n) && !visited[u + 1][v]) {
                pq.offer(new int[] { grid[u + 1][v], u + 1, v });
                visited[u + 1][v] = true;
            }
            if (isValid(v - 1, n) && !visited[u][v - 1]) {
                pq.offer(new int[] { grid[u][v - 1], u, v - 1 });
                visited[u][v - 1] = true;
            }
            if (isValid(v + 1, n) && !visited[u][v + 1]) {
                pq.offer(new int[] { grid[u][v + 1], u, v + 1 });
                visited[u][v + 1] = true;
            }
        }
        return ans;
    }
}