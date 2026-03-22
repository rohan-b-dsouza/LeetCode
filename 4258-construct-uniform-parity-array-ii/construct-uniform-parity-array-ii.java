class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        long odd = Long.MAX_VALUE;
        long even = Long.MAX_VALUE;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] % 2 == 1) {
                odd = Math.min(odd, nums1[i]);
            }
            else {
                even = Math.min(even, nums1[i]);
            }
        }
        if (odd == Long.MAX_VALUE) return true;
        if (even - odd >= 1) return true;
        return false;
    }
}