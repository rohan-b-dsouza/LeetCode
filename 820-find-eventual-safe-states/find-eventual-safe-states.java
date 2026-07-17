class Solution {
    public boolean dfs(int source, int[] visited, int[] pathVisited, int[][] graph, List<Integer> ans) {
        visited[source] = 1;
        pathVisited[source] = 1;
        for (int node: graph[source]) {
            if (visited[node] != 1) {
                if (dfs(node, visited, pathVisited, graph, ans)) return true;
            }
            else if (pathVisited[node] == 1) {
                return true;
            }
        }
        ans.add(source);
        pathVisited[source] = 0; 
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<Integer> ans = new ArrayList<>();
        int[] visited = new int[n];
        int[] pathVisited = new int[n];
        for (int i = 0; i < n; i++) {
            if (visited[i] != 1) {
                dfs(i, visited, pathVisited, graph, ans);
            }
        }
        ans.sort(null);
        return ans;
    }
}