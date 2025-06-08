// Brute

class Solution {
    public boolean search(int[] nums, int target) {
         for (int i = 0; i < nums.length; i++) {
        if (nums[i] == target) return true;
      }
      return false;
    }
}

// T.C => O(n)
// S.C => O(1)
