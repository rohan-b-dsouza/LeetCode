class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        HashSet<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int target = -nums[i];
            HashSet<Integer> hash = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int moreneeded = target - nums[j];
                if (hash.contains(moreneeded)) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], moreneeded);
                    triplet.sort(null);
                    set.add(triplet);
                }
                hash.add(nums[j]);
            }
        }
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }

}
