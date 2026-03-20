class Solution {
  
  public int[] findOrder(int N, int[][] arr) {
    List<List<Integer>> adj = new ArrayList<>();
    for (int i = 0; i < N; i++) {
      adj.add(new ArrayList<>());
    }
    int[] ans = new int[N];
    for (int i = 0; i < arr.length; i++) {
      adj.get(arr[i][1]).add(arr[i][0]);
    }
    int[] indegree = new int[N];
    for (int i = 0; i < adj.size(); i++) {
      for (int node : adj.get(i)) {
        indegree[node]++;
      }
    }
    Deque<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i < N; i++) {
      if (indegree[i] == 0) queue.offer(i);
    }
    int idx = 0;
    int count = 0;
    while (!queue.isEmpty()) {
      int curr = queue.poll();
      ans[idx++] = curr;
      count++;
      for (int node : adj.get(curr)) {
        indegree[node]--;
        if (indegree[node] == 0) queue.offer(node);
      }
    }
    if (count != N) return new int[] {};
    return ans;
  }
}
