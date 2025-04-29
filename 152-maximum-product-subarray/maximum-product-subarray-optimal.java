// Optimal - Solution (Note :- There is one more optimal solution using a variation of Kadane's Algorithm, however its not that intuitive therefore use this solution in interviews, instead of Kadane's) =>

class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int prefix = 1;
        int maxprod = Integer.MIN_VALUE;
        int suffix = 1;
        for (int i = 0; i < n; i++) {
            prefix *= nums[i];
            suffix *= nums[n - i - 1];
            maxprod = Math.max(maxprod, Math.max(prefix, suffix));
            if (prefix == 0) prefix = 1;
            if (suffix == 0) suffix = 1;
        }
        return maxprod;
    }
}

// T.C => O(n)
// S.C => O(1)
