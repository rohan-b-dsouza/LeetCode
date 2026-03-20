class Solution {
  public boolean dfs(int node, int[] visited, int[] pathVisited, List<List<Integer>> adj) {
    visited[node] = 1;
    pathVisited[node] = 1;
    for (int curr : adj.get(node)) {
        if (visited[curr] != 1) {
            if (dfs(curr, visited, pathVisited, adj)) return true;
        }
        else if (pathVisited[curr] == 1) {
            return true;
        }
    }
    pathVisited[node] = 0;
    return false;
  }
  public boolean canFinish(int N, int[][] arr) {
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      adj.add(new ArrayList<>());
    }
    for (int i = 0; i < arr.length; i++) {
      adj.get(arr[i][1]).add(arr[i][0]);
    }
    int[] visited = new int[N];
    int[] pathVisited = new int[N];
    for (int i = 0; i < N; i++) {
        if (visited[i] != 1) {
            if (dfs(i, visited, pathVisited, adj)) return false;
        }
    }
    return true;
  }
}
