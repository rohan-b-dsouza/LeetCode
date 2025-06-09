// Optimal

class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int result = Integer.MAX_VALUE;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] >= nums[low]) {
                result = Math.min(result, nums[low]);
                low = mid + 1;
            } else {
                result = Math.min(result, nums[mid]);
                high = mid - 1;
            }

        }
        return result;
    }
}

// T.C => O(log(n))
// S.C => O(1)
