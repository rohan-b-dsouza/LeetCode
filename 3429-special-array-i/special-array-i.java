class Solution {
    public boolean isArraySpecial(int[] nums) {
        int n = nums.length;
        int parity = nums[0] % 2;
        for (int i = 1; i < n; i++) {
            if (nums[i] % 2 != parity) {
                parity = nums[i] % 2;
            }
            else return false;
        }
        return true;
    }
}