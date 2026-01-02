class Solution {
    public void combination(int idx, int sum, int[] candidates, int target, List<Integer> current, List<List<Integer>> ans) {
        if (sum == target) {
            ans.add(new ArrayList<>(current));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            if (sum + candidates[i] > target) break;
            current.add(candidates[i]);
            combination(i, sum + candidates[i], candidates, target, current, ans);
            current.remove(current.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        Arrays.sort(candidates);
        combination(0, 0, candidates, target, current, ans);  
        return ans;
    }
}