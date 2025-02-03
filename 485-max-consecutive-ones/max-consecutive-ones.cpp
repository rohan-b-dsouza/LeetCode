// Optimal - Solution =>

class Solution {
public:
    int findMaxConsecutiveOnes(vector<int>& nums) {
        int cnt = 0;
        int maxones = 0;
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                cnt++;
                maxones = max(cnt, maxones);
            }
            else {
               cnt = 0;
            }
            
        }
        return maxones;
    }
};

// T.C => O(n)
// S.C => O(1)
