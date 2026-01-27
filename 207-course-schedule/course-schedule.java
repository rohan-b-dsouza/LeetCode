class Solution {
    public boolean dfs(int node, List<List<Integer>> adj, int[] visited) {
      visited[node] = 2;
      for (int currNode : adj.get(node)) {
        if (visited[currNode] == 2) return true;
        else if (visited[currNode] == 0) {
          if (dfs(currNode, adj, visited)) return true;
        }
      }
      visited[node] = 1;
      return false; 
    }
    public boolean isCyclic(int N, List<List<Integer>> adj) {
      int[] visited = new int[N];
      for (int i = 0; i < N; i++) {
        if (visited[i] == 0) {
          if (dfs(i, adj, visited)) return true;   
        }
      }
      return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
         List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : prerequisites) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }
        if (isCyclic(numCourses, adj)) return false;
        return true;
    }
}