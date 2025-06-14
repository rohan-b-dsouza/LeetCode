class Solution {
    public int noOfSubarraysFormed(int[] a, int maxSum, int m) {
        int n = a.length;
        int sum = a[0];
        int subarrayCount = 1;
        for (int i = 1; i < n; i++) {
            if (a[i] + sum <= maxSum) {
                sum += a[i];
            } else {
                sum = a[i];
                subarrayCount++;
            }
        }
        return subarrayCount;
    }

    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int low = Integer.MIN_VALUE;
        if (k > n)
            return -1;
        int high = 0;
        for (int i = 0; i < nums.length; i++) {
            low = Math.max(nums[i], low);
            high += nums[i];
        }
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (noOfSubarraysFormed(nums, mid, k) > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}