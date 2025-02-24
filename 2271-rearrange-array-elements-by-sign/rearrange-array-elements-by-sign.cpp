class Solution {
public:
    vector<int> rearrangeArray(vector<int>& nums) {
        int n = nums.size();
        vector <int> ans(n);
        int posIdx = 0;
        int negIdx = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                ans[posIdx] = nums[i];
                posIdx += 2;
            }
            else {
                ans[negIdx] = nums[i];
                negIdx += 2;
            }
        }
        return ans;   
    }
};

// T.C => O(n)
// S.C => O(n)