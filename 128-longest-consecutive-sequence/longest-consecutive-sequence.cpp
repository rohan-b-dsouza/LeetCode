class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        if (nums.empty()) return 0;
        int n = nums.size();
        sort(nums.begin(), nums.end());
        int cnt = 1;
        int maxcnt = 1;
        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                cnt++;
                maxcnt = max(maxcnt, cnt);
            } else if (nums[i] != nums[i - 1]) {
                cnt = 1;
            }
        }
        return maxcnt;
    }
};