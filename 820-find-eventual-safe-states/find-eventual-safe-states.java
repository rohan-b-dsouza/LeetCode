class Solution {
    public List<Integer> topoSort(int V, List<List<Integer>> graph) {
        int[] indegree = new int[V];
        List<Integer> ans = new ArrayList<>();
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < V; i++) {
            for (int node : graph.get(i)) {
                indegree[node]++;
            }
        }
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        int j = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            ans.add(node);
            for (int currNode : graph.get(node)) {
                indegree[currNode]--;
                if (indegree[currNode] == 0)
                    queue.offer(currNode);
            }
        }
        return ans;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        List<List<Integer>> reversedGraph = new ArrayList<>();
        for (int i = 0; i < V; i++)
            reversedGraph.add(new ArrayList<>());
        for (int i = 0; i < V; i++) {
            for (int node : graph[i]) {
                reversedGraph.get(node).add(i);
            }
        }
        List<Integer> topoSort = topoSort(V, reversedGraph);
        topoSort.sort(null);
        return topoSort;
    }
}