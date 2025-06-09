// Brute 1

class Solution {
    public int singleNonDuplicate(int[] nums) {
        if (nums.length == 1) return nums[0];
      for (int i = 0; i < nums.length; i++) {
        if (i == 0) {
            if (nums[i] != nums[i+1]) return nums[i];
        }
        else if (i == nums.length - 1) {
            return nums[i];
        }
        else {
            if (nums[i] != nums[i-1] && nums[i] != nums[i+1]) return nums[i];
        }
      }
      return -1;
    }
}

// T.C => O(n)
// S.C => O(1)
