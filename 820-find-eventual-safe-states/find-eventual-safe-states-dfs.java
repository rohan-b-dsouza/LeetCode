// Optimal

// Logic:- Recursively traverse the nodes in the graph if they are not visited. At any step if a node is reaching a visited node in the same path or a node which was a part of a cycle, then return true immediately.
// This ensures that only the nodes which are not a part of the cycle are added to the ans, as only these nodes are safe nodes.

class Solution {
    public boolean dfs(int node, int[][] graph, int[] visited, int[] safeNode) {
        visited[node] = 2;
        for (int currNode : graph[node]) {
            if (visited[currNode] == 0) {
                if (dfs(currNode, graph, visited, safeNode)) return true;
            }
            else if (visited[currNode] == 2) return true;
        }
        visited[node] = 1;
        safeNode[node] = 1;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
       int V = graph.length;
       int[] visited = new int[V];
       int[] safeNode = new int[V];
       for (int i = 0; i < V; i++) {
        if (visited[i] == 0) {
            dfs(i, graph, visited, safeNode);
        }
       }
       List<Integer> ans = new ArrayList<>();
       for (int i = 0; i < V; i++) {
        if (safeNode[i] == 1) {
            ans.add(i);
        }
       }
       return ans;
    }
}

// T.C => O(V + E)
// S.C => O(V)
