class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            map.merge(nums[i], 1, Integer::sum);
            if (ans.size() < map.get(nums[i])) {
                ans.add(new ArrayList<>());
            }
            ans.get(map.get(nums[i]) - 1).add(nums[i]);
        }
        return ans;
    }
}