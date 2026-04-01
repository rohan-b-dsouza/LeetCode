class Solution {
    public void dfs(int idx, int or, int[] max, int[] nums, int[] ans) {
        if (idx == nums.length) {
            if (or > max[0]) {
                max[0] = or;
                ans[0] = 1;
            } else if (or == max[0]) {
                ans[0] += 1;
            }
            if (idx == nums.length) {
                return;
            }
        }
        dfs(idx + 1, or | nums[idx], max, nums, ans);
        dfs(idx + 1, or, max, nums, ans);
    }

    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length;
        int[] max = new int[1];
        max[0] = -1;
        int[] ans = new int[1];
        ans[0] = 0;
        int or = 0;
        dfs(0, 0, max, nums, ans);
        return ans[0];
    }
}