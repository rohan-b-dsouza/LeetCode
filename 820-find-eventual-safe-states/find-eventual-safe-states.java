class Solution {
    public boolean dfs(int currNode, int[][] adj, int[] visited, int[] pathVisited) {
        visited[currNode] = 1;
        pathVisited[currNode] = 1;
        for (int node : adj[currNode]) {
            if (visited[node] != 1) {
                if (dfs(node, adj, visited, pathVisited))
                    return true;
            } else if (pathVisited[node] == 1) {
                return true;
            }
        }
        pathVisited[currNode] = 0;
        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        int[] visited = new int[V];
        int[] pathVisited = new int[V];
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (visited[i] != 1) {
                dfs(i, graph, visited, pathVisited);
            }
        }
        for (int i = 0; i < V; i++) {
            if (pathVisited[i] == 0)
                ans.add(i);
        }
        ans.sort(null);
        return ans;
    }
}