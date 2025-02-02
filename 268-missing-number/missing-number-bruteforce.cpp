// Brute - Force Approach =>

class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int n = nums.size();
        for (int i = 0; i <= n; i++) {
            bool flag = false;
            for (int j = 0; j < n; j++) {
                if (nums[j] == i) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                return i;
            }
        }
        return -1;
    }
};

// T.C => O(n^2)
// S.C => O(1)
