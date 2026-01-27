// Optimal (Kahn's Algorithm)

// Logic:- If the graph has a cycle, then we can't finish all courses, else we can.

class Solution {
    public int topoSort(int V, List<List<Integer>> adj) {
    int[] indegree = new int[V];
    int ans = 0;
    Deque<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i < V; i++) {
      for (int node : adj.get(i)) {
        indegree[node]++;
      }
    }
    for (int i = 0; i < V; i++) {
      if (indegree[i] == 0) {
        queue.offer(i);
      }
    }
    int j = 0;
    while (!queue.isEmpty()) {
      int node = queue.poll();
      ans++;
      for (int currNode : adj.get(node)) {
          indegree[currNode]--;
          if (indegree[currNode] == 0) queue.offer(currNode);
      }
    }
    return ans;
  }

  public boolean isCyclic(int N, List<List<Integer>> adj) {
    if (topoSort(N, adj) != N) return true;
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
            adj.get(v).add(u);
        }
        if (isCyclic(numCourses, adj)) return false;
        return true;
    }
}

// T.C => O(V + E)
// S.C => O(V + E)
