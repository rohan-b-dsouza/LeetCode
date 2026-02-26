class Solution {
public:
    int firstUniqueFreq(vector<int>& nums) {
        int n = nums.size();
        unordered_map<int, int> mp;
        for (int num : nums) {
            mp[num]++;
        }
        unordered_map<int, int> mp2;
        for (auto &[key, value] : mp) {
            mp2[value]++;
        }
        for (auto num : nums) {
            if (mp2[mp[num]] == 1) return num;
        }
        return -1;
    }
};