// Optimal - Approach =>

class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int n = nums.size();
        int i = 0;
        int j = 1;
        while (j < n) {
            if (nums[i] == 0 && nums[j] != 0) {
                swap(nums[i], nums[j]);
                i++;
                j++;
            }
            else if (nums[i] != 0) {
                i++;
                j++;
            }
            else {
                j++;
            }
        }
    }
};

// T.C => O(n)
// S.C => O(1)
