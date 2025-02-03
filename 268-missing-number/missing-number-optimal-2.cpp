// Optimal - Solution 2 =>
// Using Bit-Operations (XOR)

class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int xor1 = 0;
        int xor2 = 0;
        for (int i = 0; i < nums.size(); i++) {
            xor1 ^= nums[i];
            xor2 ^= (i + 1);
        }
        return xor1 ^ xor2;
    }
};

// T.C => O(n)
// S.C => O(1)
// Note :- Reason why solution using XOR (Optimal- 2) is more optimal than solution using sum of arrays(Optimal - 1) is mentioned in Notebook.
