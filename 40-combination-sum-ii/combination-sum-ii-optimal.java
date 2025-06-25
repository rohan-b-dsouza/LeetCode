// Optimal

class Solution {

    // Recursive helper function to find combinations
    private void func(int ind, int sum, List<Integer> nums, 
                      int[] candidates, List<List<Integer>> ans) {
        // If the sum is zero, add the current combination to the result
        if (sum == 0) {
            ans.add(new ArrayList<>(nums));
            return;
        }

        // If the sum is negative or we have exhausted the candidates, return
        if (sum < 0 || ind == candidates.length) return; 

        // Include the current candidate
        nums.add(candidates[ind]);

        // Recursively call with updated sum and next index
        func(ind + 1, sum - candidates[ind], nums, candidates, ans);

        // Backtrack by removing the last added candidate
        nums.remove(nums.size() - 1);

        // Skip duplicates: if not picking the current candidate, 
        // ensure the next candidate is different
        for(int i = ind + 1; i < candidates.length; i++) {
            if(candidates[i] != candidates[ind]) {
                func(i, sum, nums, candidates, ans);
                break;
            }
        }
    }

    // Main function to find all unique combinations
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> nums = new ArrayList<>();

        // Sort candidates to handle duplicates
        Arrays.sort(candidates);

        // Start the recursive process
        func(0, target, nums, candidates, ans);
        return ans;
    }
}

// T.C => O(2^n * k) where 2^n is no of combinations and k is avg len of each combination
// S.C => O(x * k) + O(n) ------------- where x is no of unique combinations and k is avg len of each combination and O(n) for recursive stack space
