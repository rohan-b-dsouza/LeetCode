// Optimal

// Logic:- Try to color the graphs with exactly two color such that no two adjacent nodes have the same color.
// If at any step this is violated, i.e we find that two adjacent nodes have the same color, return false.

class Solution {
  public boolean bfs(int sourceNode, int V, int[][] graph, int[] visited) {
    Deque<Integer> queue = new ArrayDeque<>();
    queue.offer(sourceNode);
    visited[sourceNode] = 1;
    while (!queue.isEmpty()) {
      int node = queue.poll();
      for (int currNode : graph[node]) {
        if (visited[currNode] != 0) {
          if (visited[currNode] == visited[node]) return false;
        } else {
          if (visited[node] == 1) visited[currNode] = 2;
          else visited[currNode] = 1;
          queue.offer(currNode);
        }
      }
    }
    return true;
  }
  public boolean isBipartite(int[][] graph) {
    int V = graph.length;
    int[] visited = new int[V];
    for (int i = 0; i < V; i++) {
      if (visited[i] == 0) {
        if (!bfs(i, V, graph, visited)) {
          return false;
        }
      }
    }
    return true;
  }
}

// T.C => O(V + E)
// S.C => O(V)
