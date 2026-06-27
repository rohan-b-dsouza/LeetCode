class Solution {
    public void permutation(int idx, int n, List<Integer> temp, boolean[] visited, int[] nums, List<List<Integer>> ans) {
        if (temp.size() == n) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                temp.add(nums[i]);
                visited[i] = true;
                permutation(idx + 1, n, temp, visited, nums, ans);
                visited[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] visited = new boolean[n];
        permutation(0, n, temp, visited, nums, ans);
        return ans;
    }
}