// Better - Approach (Two Nested Loops) =>

class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int maxSumSubarray = INT_MIN;
        for (int i = 0; i < nums.size(); i++) {
            int sum = 0;
            for (int j = i; j < nums.size(); j++) {
                sum += nums[j];
                maxSumSubarray = max(maxSumSubarray, sum);
            }
        }
        return maxSumSubarray;
    }
};

// T.C => O(n^2)
// S.C => O(1)
