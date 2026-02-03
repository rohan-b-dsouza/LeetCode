class Solution {
    public boolean isTrionic(int[] nums) {
        int n = nums.length;
        int p = -1, q = -1;
        int i = 0;
        while (i < n - 1) {
            if (nums[i + 1] == nums[i]) return false;
            if (nums[i + 1] < nums[i]) {
                p = i;
                break;
            }
            i++;
        }
        if (p <= 0)
            return false;
        while (i < n - 1) {
            if (nums[i + 1] == nums[i]) return false;
            if (nums[i + 1] > nums[i]) {
                q = i;
                break;
            }
            i++;
        }
        if (q <= p || q >= n - 1)
            return false;
        while (i < n - 1) {
            if (nums[i + 1] == nums[i]) return false;
            if (nums[i + 1] < nums[i])
                return false;
            i++;
        }
        return true;
    }
}