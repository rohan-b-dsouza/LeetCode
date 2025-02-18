// Optimal - Approach => (Using unordered map i.e hashing/hashmap)
// Note:- Check out another variant of this qn on code 360 - Two Sum. It has brute, better, optimal approach as there instead of returning indices "yes" or "no" is to be returned.

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
