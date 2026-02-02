class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int i = k;
        int j = k;
        int min = nums[k];
        int ans = min;
        while (i > 0  || j < n - 1) {
            if (i > 0 && j < n - 1) {
                if (nums[i - 1] >= nums[j + 1]) {
                    i--;
                    min = Math.min(min, nums[i]);
                }
                else {
                    j++;
                    min = Math.min(min, nums[j]);
                }
            }
            else if (j == n - 1 && i > 0) {
                i--;
                min = Math.min(min, nums[i]);
            }
            else if (i == 0 && j < n - 1) {
                j++;
                min = Math.min(min, nums[j]);
            }
            ans = Math.max(ans, min * (j - i + 1));
        }
        return ans;
    }
}