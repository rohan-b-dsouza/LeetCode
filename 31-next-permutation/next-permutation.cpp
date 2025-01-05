class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int pivotIdx = -1;
        int i = nums.size() - 2;
        while (i >= 0) { // loop to find pivot Index
            if (nums[i] < nums[i + 1]) {
                pivotIdx = i;
                break;
            }
            i--;
        }
        // if pivotIdx not found, i.e pivotIdx = -1
        if (pivotIdx == -1) { // read the Leetcode notes
            reverse(nums.begin(), nums.end());
        }
        // if pivotIdx was found
        else {
            int j = nums.size() - 1;
            while (j != pivotIdx) {
                if (nums[j] > nums[pivotIdx]) {
                    // find the smallest element at right of pivot which is
                    // larger than the pivot element and swap the pivot element
                    // with this element.
                    swap(nums[j], nums[pivotIdx]);
                    // reverse elements at right of pivot Index
                    reverse(nums.begin() + pivotIdx + 1, nums.end());
                    break; // we got the next larger array therefore, break;
                }
                j--;
            } 
        }
    } // Time Complexity -> O(n) and not O(n^2) as reverse function in while loop executes only once 
      // when the if condition hits
      // Space Complexity -> O(1)
};