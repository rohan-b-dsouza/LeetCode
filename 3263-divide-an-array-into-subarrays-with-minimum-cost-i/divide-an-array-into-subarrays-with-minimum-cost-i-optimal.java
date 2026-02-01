// Optimal

// Logic:- First element will always be nums[0], second and third element will be the minimum and second minimum in the subarray 1 to n - 1.

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

// T.C => O(n)
// S.C => O(1)
