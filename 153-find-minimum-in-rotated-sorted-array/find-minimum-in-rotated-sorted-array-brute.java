// Brute

class Solution {
    public int findMin(int[] nums) {
        int result = Integer.MAX_VALUE;
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] < result) result = nums[i];
      }
      return result;
    }
}

// T.C => O(n)
// S.C => O(1)


