class Solution {
public:
    int findMaxConsecutiveOnes(vector<int>& nums) {
        int cnt = 0;
        int maxones = 0;
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) cnt = 0;
            else {
                cnt++;
            }
            maxones = max(cnt, maxones);
        }
        return maxones;
    }
};