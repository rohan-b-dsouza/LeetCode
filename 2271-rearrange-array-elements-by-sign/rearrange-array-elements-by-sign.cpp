class Solution {
public:
    vector<int> rearrangeArray(vector<int>& nums) {
        vector <int> arr1;
        vector <int> arr2;
        int n = nums.size();
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                arr1.push_back(nums[i]);
            }
            else {
                arr2.push_back(nums[i]);
            }
        }
        int j = 0;
        int k = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                nums[i] = arr1[j];
                j++;
            }
            else {
                nums[i] = arr2[k];
                k++;
            }
        }
        return nums;
    }

};