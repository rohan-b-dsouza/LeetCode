// Brute

class Solution {
    public int noOfSubarrayFormed(int[] a, int maxSum) {
        int n = a.length;
        int sum = a[0];
        int studcnt = 1;
        for (int i = 1; i < n; i++) {
            if (a[i] + sum <= maxSum) {
                sum += a[i];
            } else {
                sum = a[i];
                studcnt++;
            }
        }
        return studcnt;
    }

    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        if (k > n)
            return -1;
        int low = Integer.MIN_VALUE;
        int high = 0;
        for (int i = 0; i < nums.length; i++) {
            low = Math.max(nums[i], low);
            high += nums[i];
        }
        for (int i = low; i <= high; i++) {
            if (noOfSubarrayFormed(nums, i) <= k) {
                return i;
            }
        }
        return -1;
    }
}

// T.C => O((max - sum) * (n))
// S.C => O(1)
