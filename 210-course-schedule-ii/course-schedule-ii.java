class Solution { 
  public boolean dfs(int sourceNode, List<List<Integer>> adj, int[] visited, Deque<Integer> stack, int[] pathvisited) {
    visited[sourceNode] = 1;
    pathvisited[sourceNode] = 1;
    for (int node : adj.get(sourceNode)) {
        if (visited[node] != 1) {
            if (dfs(node, adj, visited, stack, pathvisited)) return true;
        } 
        else if (pathvisited[node] == 1) {
            return true;
        }
    }
    pathvisited[sourceNode] = 0;
    stack.push(sourceNode);
    return false;
  }
  public int[] getTopoSort(List<List<Integer>> adj, int N) {
    int[] visited = new int[N];
    int[] pathvisited = new int[N];
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < N; i++) {
        if (visited[i] != 1) {
            if (dfs(i, adj, visited, stack, pathvisited)) return new int[] {};
        }
    }
    int[] ans = new int[N];
    int idx = 0;
    while (!stack.isEmpty()) {
        ans[idx++] = stack.pop();
    }
    return ans;
  } 
  public int[] findOrder(int N, int[][] arr) {
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < N; i++) adj.add(new ArrayList<>());
    for (int[] edge : arr) {
      int u = edge[0];
      int v = edge[1];
      adj.get(v).add(u);
    }
    return getTopoSort(adj, N);
  }
}