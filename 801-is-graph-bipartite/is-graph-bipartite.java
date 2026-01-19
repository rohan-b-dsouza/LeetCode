class Solution {
  public boolean dfs(int sourceNode, int[][] graph, int[] visited, int color) {
    visited[sourceNode] = color;
    for (int node : graph[sourceNode]) {
        if (visited[node] == 0) {
           boolean flag = dfs(node, graph, visited, visited[sourceNode] == 1 ? 2 : 1);
           if (!flag) return false;
        }
        else if (visited[node] == visited[sourceNode]) {
            return false;
        }
    }
    return true;
  }

  public boolean isBipartite(int[][] graph) {
    int V = graph.length;
    int[] visited = new int[V];
    for (int i = 0; i < V; i++) {
        if (visited[i] == 0) {
            if (!dfs(i, graph, visited, 1)) {
                return false;
            }
        }
    }
    return true;
  }
}
