// Optimal - Approach 1 =>
// Using sum of the array 

class Solution {
public:
    int missingNumber(vector<int>& nums) {
       int n = nums.size();
       int sum1 = accumulate(nums.begin(), nums.end(), 0);
       int sum2 = (n * (n + 1)) / 2;
       return sum2 - sum1;
    }
};

// T.C => O(n) for the accumulate function (i.e sum of array)
// S.C => O(1)
