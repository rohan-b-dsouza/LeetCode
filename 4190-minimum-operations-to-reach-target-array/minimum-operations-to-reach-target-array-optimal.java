// Optimal

// Logic:- If a number is not matching its target then it means we need to perform operation for this number x. Hence, put it into the set.
// Even if there are multiple occurences of this number where some of it may already be matching their corresponding target, it won't matter.
// Now, atlast return the size of the set as this is the no. of operations required.

class Solution {
    public int minOperations(int[] nums, int[] target) {
      int n = nums.length;
      Set<Integer> st = new HashSet<>();
      for (int i = 0; i < n; i++) {
        if (nums[i] != target[i]) {
          st.add(nums[i]);
        }
      }
      return st.size();
    }
}

// T.C => O(n)
// S.C => O(n)
