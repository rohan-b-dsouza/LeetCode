// Better - Approach =>

class Solution {
public:
    void sortColors(vector<int>& nums) {
        int countZ = 0, countO = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] == 0) countZ++;
            else if (nums[i] == 1) countO++;
        }
        for (int i = 0; i < nums.size(); i++) {
            if (i < countZ) nums[i] = 0;
            else if (i < countZ + countO) nums[i] = 1;
            else nums[i] = 2;
        }
    }
};

// T.C => O(n) + O(n) = O(2n) = O(n)
// S.C => O(1)
