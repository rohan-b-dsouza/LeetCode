class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 1; i <= n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge: times) {
            int u = edge[0]; int v = edge[1]; int wt = edge[2];
            graph.get(u).add(new int[] {v, wt});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b)-> {
            return Integer.compare(a[0], b[0]);
        });
        int[] dist = new int[n + 1];
        Arrays.fill(dist, (int) (1e9));
        dist[k] = 0;
        pq.offer(new int[] {0, k});
        while (!pq.isEmpty()) {
            int[] peak = pq.poll();
            int wt = peak[0];
            int node = peak[1];
            for (int[] curr: graph.get(node)) {
                if (wt + curr[1] < dist[curr[0]]) {
                    dist[curr[0]] = wt + curr[1];
                    pq.offer(new int[] {dist[curr[0]], curr[0]});
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == (int) (1e9)) return -1;
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}