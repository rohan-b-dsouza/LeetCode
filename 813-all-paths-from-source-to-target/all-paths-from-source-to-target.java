class Solution {
    public void dfs (List<Integer> temp, int node, int[][] graph, List<List<Integer>> ans) {
        if (node == graph.length - 1) {
            ans.add(new ArrayList<>(temp));
            return;
        }  
        for (int curr : graph[node]) {
            temp.add(curr);
            dfs(temp, curr, graph, ans);
            temp.remove(temp.size() - 1);
        }
        
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = graph.length;
        List<Integer> temp = new ArrayList<>();
        temp.add(0);
        dfs(temp, 0, graph, ans);
        return ans;
    }
}