// Brute-Force Approach (Three Nested Loops) =>

class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int maxSumSubarray = INT_MIN;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = i; j < nums.size(); j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                maxSumSubarray = max(maxSumSubarray, sum);
            }
        }
        return maxSumSubarray;
    }
};

// T.C => O(n^3)
// S.C => O(1)
