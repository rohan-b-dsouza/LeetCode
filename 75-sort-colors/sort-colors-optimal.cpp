// Optimal - Approach (Dutch National Flag Algorithm) =>
// (Three - Pointer Approach) =>

class Solution {
public:
    void sortColors(vector<int>& nums) {
        int mid = 0, low = 0, high = nums.size() - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums[mid], nums[low]);
                low++;
                mid++;
            }
            else if (nums[mid] == 2) {
                swap (nums[mid], nums[high]);
                high--;
            }
            else mid++;
        }
    }
};

// T.C => O(n)
// S.C => O(1)
