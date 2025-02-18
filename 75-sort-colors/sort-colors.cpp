class Solution {
public:
    void sortColors(vector<int>& nums) {
        int cntOne = 0;
        int cntZero = 0;
       for (int i = 0; i < nums.size(); i++) {
        if (nums[i] == 0) cntZero++;
        else if (nums[i] == 1) cntOne++;
       } 
       for (int i = 0; i < nums.size(); i++) {
        if (i < cntZero) {
            nums[i] = 0;
        }
        else if (i >= cntZero && i < (cntZero + cntOne)) {
            nums[i] = 1;
        }
        else nums[i] = 2;
       }
    }
};