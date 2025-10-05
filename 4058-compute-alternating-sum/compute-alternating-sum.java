class Solution {
    public int alternatingSum(int[] nums) {
        int sum = 0;
        int sign = 1;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            sum += sign * nums[i];
            sign = -sign;
        }
        return sum;
    }
    
}