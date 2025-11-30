// Brute 

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        // Sort the array and return the kth largest element
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}

// T.C => O(n * log (n))
// S.C => O(1)
