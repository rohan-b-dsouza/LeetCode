// Optimal

class Solution {
    public void combinations(int idx, int sum, int[] candidates, int target, List<List<Integer>> ans, List<Integer> current) {  
        if (sum == target) {
            ans.add(new ArrayList<>(current));
            return;
        }
        for (int i = idx; i < candidates.length; i++) {
            if (i > idx && candidates[i] == candidates[i - 1]) continue;
            if (sum + candidates[i] > target) break;
            current.add(candidates[i]);
            combinations(i + 1, sum + candidates[i], candidates, target, ans, current);
            current.remove(current.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
     Arrays.sort(candidates);
     List<Integer> current = new ArrayList<>();
     List<List<Integer>> ans = new ArrayList<>();
     combinations(0, 0, candidates, target, ans, current);   
     return ans;
    }
}

    // T.C => O(2^n * k) where 2^n is no of combinations and k is avg len of each combination
    // S.C => O(x * k) + O(n) ------------- where x is no of unique combinations and k is avg len of each combination and O(n) for recursive stack space

// Important logic here:- 
/*
    if (i > idx && candidates[i] == candidates[i - 1]) continue;
    This ensures : same value is used only once per level,duplicates are skipped horizontally, not vertically
*/
