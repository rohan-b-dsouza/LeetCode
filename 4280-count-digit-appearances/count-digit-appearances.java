class Solution {
    public int countDigitOccurrences(int[] nums, int digit) {
        int n = nums.length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            if (x == 0 && digit == 0) cnt++;
            while (x > 0) {
                int dig = x % 10;
                if (dig == digit) cnt++;
                x = x / 10;
            }
        }
        return cnt;
    }
}