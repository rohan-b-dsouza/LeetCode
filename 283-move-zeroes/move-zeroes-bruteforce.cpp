// Brute - Force Approach =>

class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        vector <int> temp;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] != 0) temp.push_back(nums[i]);
        }
        for (int i = 0; i < temp.size(); i++) {
            nums[i] = temp[i];
        }
        for (int i = temp.size(); i < nums.size(); i++) {
            nums[i] = 0;
        }
    }
};

// T.C => O(n) + O(x) + O(n - x) = O(2n) where x = no. of non-zero numbers
// S.C => O(1)
