// Optimal 

class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int n = nums.length;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target)
                return true;
            if (nums[mid] == nums[low] && nums[low] == nums[high]) {
                low++;
                high--;
            } else if (nums[mid] >= nums[low]) {
                if (target < nums[mid] && target >= nums[low]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else {
                if ((target > nums[mid] && target <= nums[high])) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return false;
    }
}

// T.C => O(log(n)) in best and avg case, but O(n/2) in worst case i.e when all elements are same.
// S.C => O(1)
