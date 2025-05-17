class Solution {
    public int binarySearch(int low, int high, int[] nums, int target) {
        if (low > high) return -1;
        int mid = (low + high) / 2;
        if (nums[mid] == target) return mid;
        else if (nums[mid] < target) {
            return binarySearch(mid + 1, high, nums, target);
        }
        return binarySearch(low, mid - 1,  nums, target);
    }
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        return binarySearch(0, nums.length - 1, nums, target);
    }
    
}