// Brute - Force Approach =>

class Solution {
public:
    vector<int> rearrangeArray(vector<int>& nums) {
        int n = nums.size();
        vector<int> posi;
        vector<int> nega;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) posi.push_back(nums[i]);
            else
                nega.push_back(nums[i]);
        }
        for (int i = 0; i < n / 2; i++) {
            nums[2 * i] = posi[i];
            nums[2 * i + 1] = nega[i];
        }
        return nums;
    }
};

// T.C => O(n) + O(n / 2) = O(3n / 2) = O(n)
// S.C => O(n / 2) + O(n / 2) = O(n)
