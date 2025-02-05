// Better - Approach 2 
// Using unordered Map (less - better than hash array, refer internet for reason)

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

// T.C => O(n * 1) + O(n * 1) = O(2n) = O(n) .............as for unordered map operations take O(1) T.C in avg and best case & worst case rarely happens so not considered.
// S.C => O(n) for extra unordered map used
