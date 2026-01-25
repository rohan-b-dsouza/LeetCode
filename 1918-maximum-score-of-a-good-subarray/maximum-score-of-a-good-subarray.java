class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        int i = k;
        int j = k;
        int currMin = nums[k];
        long ans = currMin;
        while (i - 1 > 0 || j + 1 < n) {
            if (i - 1 >= 0 && j + 1 < n) {
                if (nums[i - 1] >= nums[j + 1]) {
                    currMin = Math.min(nums[i - 1], currMin);
                    i--;
                }
                else {
                   currMin = Math.min(nums[j + 1], currMin);
                   j++;
                }
            }
            else if (i - 1 < 0) {
                currMin = Math.min(nums[j + 1], currMin);
                j++;
            }
            else {
                currMin = Math.min(nums[i - 1], currMin);
                i--;
            }
            ans = Math.max(ans, currMin * 1L * (j - i + 1));
        }
        return (int) ans;
    }
}