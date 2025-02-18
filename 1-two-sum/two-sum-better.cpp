// Better - Approach => (Using Hashing)

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map <int, int> mpp;
        for (int i = 0; i < nums.size(); i++) {
            int moreneeded = target - nums[i];
            if (mpp.find(moreneeded) != mpp.end()) {
                return {i, mpp[moreneeded]};
            }
            mpp[nums[i]] = i;
        }
        return {};
    }
};

// T.C => O(n)
// S.C => O(n) as extra unordered map is used
