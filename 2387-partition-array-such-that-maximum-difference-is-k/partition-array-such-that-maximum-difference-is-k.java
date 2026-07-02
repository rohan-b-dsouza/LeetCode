class Solution {
    public int partitionArray(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int max = nums[0]; int min = nums[0];
        int ans = 1;
        for (int i = 0; i < n; i++) {
            max = Math.max(nums[i], max);
            min = Math.min(nums[i], min);
            if (max - min > k) {
                max = nums[i];
                min = nums[i];
                ans++;
            } 
        }
        return ans;
    }
}