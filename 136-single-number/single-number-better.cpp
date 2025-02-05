// Better - Approach - 1 => (Using unordered map) =>

class Solution {
public:
    int singleNumber(vector<int>& nums) {
        unordered_map <int, int> mpp;
        for (int i = 0; i < nums.size(); i++) {
            mpp[nums[i]]++;
        }
        for (auto it : mpp) {
            if (it.second == 1) return it.first;
        }
        return -1;
    }
};

// T.C => O(n) + O(x) = O(n) ....................{where x is the number of key - value pairs in map}
// S.C => O(x) ...................{where x is the number of key - value pairs in map}
