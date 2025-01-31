// Optimal - Approach =>
// (Brute-Approach in Code - 360 -> Left Rotate array by k places)

class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        int n = nums.size();
        k %= n;
        reverse(nums.begin(), nums.end());
        reverse(nums.begin(), nums.begin() + k);
        reverse(nums.begin() + k, nums.end());
    }
};

// T.C => O(n) + O(k) + O(n - k) = O(2n)
// S.C => O(1)  
