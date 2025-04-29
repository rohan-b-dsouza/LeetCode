// Brute - Force 

class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxprod = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int prod = 1;
                for (int k = i; k <= j; k++) {
                    prod *= nums[k];
                }
                maxprod = Math.max(maxprod, prod);
            }
        }
        return maxprod;
    }
}

// T.C => O(n^3)
// S.C => O(1)
