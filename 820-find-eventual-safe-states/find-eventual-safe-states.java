class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
       int n = graph.length;
       List<Integer> ans = new ArrayList<>();
       List<List<Integer>> revGraph = new ArrayList<>();
       Deque<Integer> queue = new ArrayDeque<>();
       for (int i = 0; i < n; i++) revGraph.add(new ArrayList<>());
       for (int i = 0; i < n; i++) {
        for (int node: graph[i]) {
            revGraph.get(node).add(i);
        }
       }
       int[] indegree = new int[n];
       for (int i = 0; i < n; i++) {
        for (int node: revGraph.get(i)) {
            indegree[node]++;
        }
       }
       for (int i = 0; i < n; i++) {
        if (indegree[i] == 0) {
            queue.offer(i);
        }
       }
       while (!queue.isEmpty()) {
        int peak = queue.poll();
        ans.add(peak);
        for (int node: revGraph.get(peak)) {
            indegree[node]--;
            if (indegree[node] == 0) {
                queue.offer(node);
            }
        }
       }
       ans.sort(null);
       return ans;
    }
}