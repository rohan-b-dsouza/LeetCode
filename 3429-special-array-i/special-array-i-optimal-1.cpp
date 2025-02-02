// Optimal - Solution 1 (Bitwise - Operation Solution is more efficient, refer leetcode editorial)

class Solution {
public:
    bool isArraySpecial(vector<int>& nums) {
        if (nums.size() == 1) return true;
        for (int i = 0; i < nums.size() - 1; i++) {
            if ((nums[i] % 2) == (nums[i + 1] % 2)) return false;
        }
        return true;
    }
};

// T.C => O(n)
// S.C => O(1)
