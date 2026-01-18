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