// Optimal - Approach =>

class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int idx = -1;
        int n = nums.size();
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                idx = i;
                break;
            }
        }
        if (idx == -1)
            reverse(nums.begin(), nums.end());
        else {
            for (int j = n - 1; j > idx; j--) {
                if (nums[j] > nums[idx]) {
                    swap(nums[j], nums[idx]);
                    break;
                }
            }
            reverse(nums.begin() + (idx + 1), nums.end());
        }
    }
};

// T.C => O(3n) = O(n)
// S.C => O(1) 
