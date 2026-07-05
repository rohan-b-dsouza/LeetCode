class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        int n = nums.length;
        int imax = -1;
        int ans = -1;
        for (int j = k, i = 0; j < n; j++, i++){
            imax = Math.max(imax, nums[i]);
            ans = Math.max(nums[j] + imax, ans);
        }
        return ans;
    }
}