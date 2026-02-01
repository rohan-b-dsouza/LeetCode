class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length;
        int first =  nums[0];
        int second = 51;
        int third = 51;
        for (int i = 1; i < n; i++) {
            if (nums[i] < second) {
                third = second;
                second = nums[i];
            }
            else if (nums[i] < third) third = nums[i];
        }
        return (first + second + third);
    }
}