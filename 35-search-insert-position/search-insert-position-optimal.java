// Optimal

class Solution {
    public int searchInsert(int[] nums, int target) {
         int ans = nums.length;
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= target) {
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    
    }
    
    }

// T.C => O(logn)
// S.C => O(1)
