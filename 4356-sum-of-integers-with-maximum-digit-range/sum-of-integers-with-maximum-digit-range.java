class Solution {
    public int maxDigitRange(int[] nums) {
        int n = nums.length;
        int mx = Integer.MIN_VALUE;
        int maxRange = -1;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            while (num != 0) {
                int digit = num % 10;
                max = Math.max(max, digit);
                min = Math.min(min, digit);
                num = num / 10;
            }
            if (max - min > maxRange) {
                maxRange = max - min;
                ans = nums[i];
            }
            else if (max - min == maxRange) {
                ans += nums[i];
            }
        }
        return ans;
    }
}