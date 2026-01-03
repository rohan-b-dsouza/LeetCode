class Solution {
    public void bfs(int sourceNode, int V, int[][] isConnected, int[] visited) {
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(sourceNode);
        visited[sourceNode] = 1;
        while(!queue.isEmpty()) {
            int currNode = queue.poll();
            for (int node = 0; node < V; node++) {
                if (isConnected[currNode][node] == 0) continue; 
                if (visited[node] != 1) {
                    queue.offer(node);
                    visited[node] = 1;
                }
            }
        }
    }
    public void dfs(int sourceNode, int V, int[][] isConnected, int[] visited) {
        visited[sourceNode] = 1;
        for (int node = 0; node < V; node++) {
            if (isConnected[sourceNode][node] == 0) continue;
            if (visited[node] != 1) {
                dfs(node, V, isConnected, visited);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        int provinces = 0;
        int[] visited = new int[V];
        for (int i = 0; i < V; i++) {
            if (visited[i] != 1) {
                provinces++;
                // bfs(i, V, isConnected, visited);
                dfs(i, V, isConnected, visited);
            }
        } 
        return provinces;
    }
}

// T.C => DFS / BFS:- O(V^2)
// S.C => DFS:- O(V) visited array + O(V) recursion stack
//        BFS:- O(V) visited array + O(V) queue

