class Solution {
    public int countPaths(int n, int[][] roads) {
        long[] ways = new long[n];
        long[] dist = new long[n];
        long MOD = (long) (1e9) + 7;
        List<List<long[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++)
            graph.add(new ArrayList<>());
        for (int[] road : roads) {
            graph.get(road[0]).add(new long[] { road[1], road[2] });
            graph.get(road[1]).add(new long[] { road[0], road[2] });
        }
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;
        PriorityQueue<long[]> pq = new PriorityQueue<>(
                (a, b) -> {
                    return Long.compare(a[0], b[0]);
                });
        pq.offer(new long[] { 0, 0 });
        while (!pq.isEmpty()) {
            long[] peak = pq.poll();
            int peakNode = (int) peak[1];
            long peakWeight = peak[0];
            for (long[] node : graph.get(peakNode)) {
                int currNode = (int) node[0];
                long currWeight = node[1];
                if (peakWeight + currWeight < dist[currNode]) {
                    dist[currNode] = peakWeight + currWeight;
                    ways[currNode] = ways[peakNode];
                    pq.offer(new long[] { (long) dist[currNode], currNode });
                } else if (peakWeight + currWeight == dist[currNode]) {
                    ways[currNode] = (ways[currNode] + ways[peakNode]) % MOD;
                }
            }
        }
        return (int) (ways[n - 1] % MOD);
    }
}