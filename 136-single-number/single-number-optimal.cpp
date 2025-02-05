// Optimal Solution (Using Bit-Manipulation) =>

class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int n = nums.size();
        int xor1 = nums[0];
        for (int i = 1; i < n; i++) {
            xor1 ^= nums[i];
        }
        return xor1;
    }
};

// T.C => O(n)
// S.C => O(1)
