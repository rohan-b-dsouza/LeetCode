// Optimal - Solution =>

class Solution {
public:
    bool parity(int num) {
        if (num % 2 == 0) return true;
        else return false;
    }
    bool isArraySpecial(vector<int>& nums) {
        if (nums.size() == 1) return true;
        for (int i = 0; i < nums.size() - 1; i++) {
            if (parity(nums[i]) == parity(nums[i + 1])) return false;
        }
        return true;
    }
};

// T.C => O(n)
// S.C => O(1)