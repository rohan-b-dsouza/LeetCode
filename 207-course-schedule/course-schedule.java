class Solution {
    public boolean dfs(int source, List<List<Integer>> adj, int[] visited, int[] pathVisited) {
        visited[source] = 1;
        pathVisited[source] = 1;
        for (int node: adj.get(source))  {
            if (visited[node] != 1) {
                if (dfs(node, adj, visited, pathVisited)) return true;
            }
            else if (pathVisited[node] == 1) {
                return true;
            }
        }
        pathVisited[source] = 0;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        int[] visited = new int[n];
        int[] pathVisited = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] edge: prerequisites) {
            adj.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < n; i++) {
            if (visited[i] != 1) {
                if (dfs(i, adj, visited, pathVisited)) return false;
            }
        }
        return true;
    }
}