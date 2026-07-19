class Solution {
    public boolean dfs(int source, List<List<Integer>> adj, int[] visited, int[] ans, int[] pathVisited, int[] idx) {
        visited[source] = 1;
        pathVisited[source] = 1;
        for (int node: adj.get(source))  {
            if (visited[node] != 1) {
                if (dfs(node, adj, visited, ans, pathVisited, idx)) return true;
            }
            else if (pathVisited[node] == 1) {
                return true;
            }
        }
        ans[idx[0]--] = source;
        pathVisited[source] = 0;
        return false;
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        int[] visited = new int[n];
        int[] pathVisited = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] edge: prerequisites) {
            adj.get(edge[1]).add(edge[0]);
        }
        int[] ans = new int[n];
        int[] idx = new int[1];
        idx[0] = n - 1;
        for (int i = 0; i < n; i++) {
            if (visited[i] != 1) {
                if (dfs(i, adj, visited, ans, pathVisited, idx)) return new int[] {};
            }
        }
        return ans;

    }
}