// Optimal

class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if (n == 1 || nums[0] > nums[1]) return 0;
        if (nums[n - 1] > nums[n - 2]) return n - 1;
        int low = 1;
        int high = n - 2;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // if nums[mid] is the peak
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) {
                return mid;
            }
            // if we are on the increasing slope
            if (nums[mid] > nums[mid - 1]) {
                low = mid + 1;
            }
            // if we are on the decreasing slope or nums[mid] is the trough point
            else {
                high = mid - 1;
            }
        }
        return -1;
    }
}

// T.C => O(log (n)) 
// S.C => O(1)