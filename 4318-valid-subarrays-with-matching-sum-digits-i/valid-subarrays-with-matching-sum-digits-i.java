class Solution {
    public int countValidSubarrays(int[] nums, int x) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            long sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                long ldigit = sum % 10;
                long temp = sum;
                long fdigit = -1;
                while (temp != 0) {
                    fdigit = temp % 10;
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