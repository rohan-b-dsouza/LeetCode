// Optimal (Quick Select Algorithm)
// This problem uses quick sort but unlike quicksort which sorts entire array and recursively calls both left and right array, here we choose whether we want to go to left array or right array

class Solution {
    // Quick Sort Random Pivot Partition Function for descending order
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
    // Run a while with true
    while (true) {
      // Get the partitionIdx
      int partitionIdx = partition(nums, low, high);
      // If partitionIdx is equal to k - 1 return the element at this index 
      if (partitionIdx == k - 1) return nums[partitionIdx];
      // Else if (k - 1) is smaller than partitionIdx it means element lies on left side, hence shrink array from right
      else if ((k - 1) < partitionIdx) {
        high = partitionIdx - 1;
      }
      // Else shrink array from left
      else {
        low = partitionIdx + 1;
      }
    }
    }
}

// T.C => Avg. Case :- O(n) as in each step its like we are dividing the array into 2 parts....{n + n/2 + n/4 ... = n}, Worst Case:- O(n^2) when pivot is extreme hence leading to n + n-1 + n-2 ........ = O(n^2) (High Unlikely as we use random pivot)
// S.C => O(1)
