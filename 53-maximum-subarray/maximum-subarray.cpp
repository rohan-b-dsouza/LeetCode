// Optimal - Solution => (Kadane's Algorithm) =>

class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int sum = 0;
        int largestSumSubarray= INT_MIN;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums[i];
            largestSumSubarray = max(sum, largestSumSubarray);
            if (sum < 0) {
                sum = 0;
            }  
        }
        return largestSumSubarray;
    }
};

// T.C => O(n)
// S.C => O(1)