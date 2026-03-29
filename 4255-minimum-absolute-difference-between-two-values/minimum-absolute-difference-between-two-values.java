class Solution {
    public int minAbsoluteDifference(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int idx = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] != 0) {
                if (idx != -1 && nums[idx] != nums[i]) min = Math.min(min, Math.abs(i - idx));
                idx = i;
            } 
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}