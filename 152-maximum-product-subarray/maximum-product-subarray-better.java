// Better - Solution 

class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxprod = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int prod = 1;
            for (int j = i; j < n; j++) {
                prod *= nums[j];
                maxprod = Math.max(maxprod, prod);
            }
        }
        return maxprod;
    }
}

// T.C => O(n^2)
// S.C => O(1)
