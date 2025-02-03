class Solution {
public:
    int missingNumber(vector<int>& nums) {
        unordered_map <int, int> mpp;
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            mpp[nums[i]]++;
        }
        for (int i = 0; i <= n; i++) {
            if (mpp[i] == 0)
            return i;
        }
        return -1;
    }
};