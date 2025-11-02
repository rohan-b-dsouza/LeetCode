// Optimal (This problem is an extension of the GFG Problem: Second Largest)

class Solution {
    public long maxProduct(int[] nums) {
        int n = nums.length;
        // Get the max and second max element
        // Note :- Since we need maximum product its possible that the array may have max element mroe than once which means second max can be same as max so to ensure we don't miss that we need to use = sign too in num >= max
        long maxAbs = Math.abs(nums[0]);
        long smaxAbs = -1;
        // Get the largest 2 elements in the array
        for (int i = 1; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num >= maxAbs) {
                smaxAbs = maxAbs;
                maxAbs = num;
            }
            else if (num > smaxAbs) {
                smaxAbs = num;
            }
        }
        // Get the maximum product by multiple max, smax and 10^5
        long prod = maxAbs * smaxAbs * 100000;
        return prod;
    }
}

// NOTE :- Since we require the maximum product and we must replace one element with an element in the range [10^5,10^-5] we will obv take the maximum in this range i.e 10^5. Also, since prod of two numbers may give us negative but anyways since we
// have third element as -10^5 we can turn into positive or if two numbers gave us positive result then we can take 10^5 as third number. From this we can conclude that we don't need to consider signs as we can guaranteed have a positive product. Therefore, 
// we consider absolute values in the code

// T.C => O(n)
// S.C => O(1)