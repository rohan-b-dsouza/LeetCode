class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    HashSet<List<Integer>> ans = new HashSet<>();
    Arrays.sort(nums);
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      int target = -nums[i];
      HashSet<Integer> st = new HashSet<>();
      for (int j = i + 1; j < n; j++) {
        if (st.contains(target - nums[j])) {
            List<Integer> triplet = new ArrayList<>(Arrays.asList(nums[i], nums[j], target-nums[j]));
            ans.add(triplet);
        }
        st.add(nums[j]);
      }
    }
    List<List<Integer>> finalans = new ArrayList(ans);
    return finalans;
  }
}
