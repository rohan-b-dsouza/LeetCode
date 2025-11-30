class Solution {
    public int partition(int[] nums, int low, int high) {
    int i = low;
    int j = high;
    int randomPivotIndex = low + (int) (Math.random() * (high - low + 1));
    int swapper = nums[low];
    nums[low] = nums[randomPivotIndex];
    nums[randomPivotIndex] = swapper;
    while (i < j) {
      while (i < high && nums[i] >= nums[low]) i++;
      while (j > low && nums[j] < nums[low]) j--;
      if (i < j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
      }
    }
    int temp = nums[low];
    nums[low] = nums[j];
    nums[j] = temp;
    return j;
  }
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
    int low = 0;
    int high = n - 1;
    while (true) {
      int partitionIdx = partition(nums, low, high);
      if (partitionIdx == k - 1) return nums[partitionIdx];
      else if ((k - 1) < partitionIdx) {
        high = partitionIdx - 1;
      }
      else {
        low = partitionIdx + 1;
      }
    }
    }
}