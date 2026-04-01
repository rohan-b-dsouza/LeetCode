class Solution {
    public void dfs(int idx, int or, int n, int[] nums, int maxor, int[] count) {
        if (or == maxor) {
            count[0] += (1 << (n - idx));
            return;
        }
        if (idx == n) return;
        dfs(idx + 1, or | nums[idx], n, nums, maxor, count);
        dfs(idx + 1, or, n, nums, maxor, count);
    }
    public int countMaxOrSubsets(int[] nums) {
        int n = nums.length;
        int[] count = new int[n];
        int maxor = 0;
        for (int i = 0; i < n; i++) {
            maxor |= nums[i];
        }
        dfs(0, 0, n, nums, maxor, count);
        return count[0];
    }
}