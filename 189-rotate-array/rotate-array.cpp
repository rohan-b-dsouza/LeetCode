class Solution {
public:
    void rotate(vector<int>& nums, int k) {
            k %= nums.size(); // this statement handles the condition where k(steps) can be greater than size of array
            reverse(nums.begin(), nums.begin() + nums.size() - k); // reverse first part (i.e the part which is not to be rotated)
            reverse(nums.begin() + nums.size() - k, nums.end()); // reverse second part (i.e the part which is to be rotated)
            reverse(nums.begin(), nums.end()); // reverse entire array
    }
};