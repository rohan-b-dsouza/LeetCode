// Better

class Solution {
    public int specialTriplets(int[] nums) {
        int n = nums.length;
        long cnt = 0;
        int mod = 1000000007;
        for (int j = 0; j < n; j++) {
            int left = 0, right = 0;
            for (int i = 0; i < j; i++) {
                if (nums[i] == nums[j] * 2) {
                    left++;
                }
            }
            for (int k = j + 1; k < n; k++) {
                if (nums[k] == nums[j] * 2) {
                    right++;
                }
            }
            cnt += (long) left * right;
        }
        return (int) (cnt % mod);
    }

}

// T.C => O(n ^ 2)
// S.C => O(1)
