// Brute-Force Approach => 

class Solution {
public:
    bool linearSearch(vector<int>& arr, int target) {
        for (int i = 0; i < arr.size(); i++) {
            if (arr[i] == target)
                return true;
        }
        return false;
    }

    int longestConsecutive(vector<int>& nums) {
        if (nums.empty())
            return 0;
        int maxcnt = 1;
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            int x = nums[i];
            while (linearSearch(nums, x + 1)) {
                cnt++;
                x++;
            }
            maxcnt = max(maxcnt, cnt);
        }
        return maxcnt;
    }
};
// T.C => O(n^2)
// S.C => O(1)
