class Solution {
    public int minPairSum(int[] nums) {
        int n = nums.length;
        int ans = -1;
        Arrays.sort(nums);
        for (int i = 0; i < n / 2; i++) {
            System.out.print(nums[i] + nums[n - i - 1] + " ");
            ans = Math.max(nums[i] + nums[n - i - 1], ans);
        }
        return ans;
    }
}