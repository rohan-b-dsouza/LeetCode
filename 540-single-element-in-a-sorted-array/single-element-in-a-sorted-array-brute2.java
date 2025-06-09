// Brute 2

class Solution {
    public int singleNonDuplicate(int[] nums) {
      int xor = 0;
      for (int i = 0; i < nums.length; i++) {
        xor ^= nums[i];
      }
      return xor;
    }
}

// T.C => O(n)
// S.C => O(1)
