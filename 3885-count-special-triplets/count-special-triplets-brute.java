// Brute

class Solution {
    public int specialTriplets(int[] nums) {
        int n = nums.length;
        long cnt = 0;
        int mod = 1000000007;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if ((nums[i] == (long) nums[j] * 2) && (nums[k] == (long)nums[j] * 2)) {
                        cnt++;
                    }
                }
            }
        }
        return (int)(cnt % mod);
    }

}

// T.C => O(n ^ 3)
// S.C => O(1)
