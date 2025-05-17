class Solution {
    public int binarySearch(int low, int high, int[] nums, int target) {
        int ans = -1;
        if (low > high) return ans;
        int mid = (low + high) / 2;
        if (nums[mid] == target) ans = mid;
        else if (nums[mid] < target) {
            ans = binarySearch(mid + 1, high, nums, target);
        }
        else {
            ans = binarySearch(low, high - 1,  nums, target);
        }
        return ans;
    }
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        return binarySearch(0, nums.length - 1, nums, target);
    }
    
}