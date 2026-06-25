class Solution {
    public int countValidSubarrays(int[] nums, int x) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                long fdigit = sum % 10;
                long temp = sum;
                long ldigit = -1;
                while (temp != 0) {
                    ldigit = temp % 10;
                    temp = temp / 10;
                }
                if (fdigit == ldigit && fdigit == x) {
                    ans++;
                }
            }
        }
        return ans;
    }
}