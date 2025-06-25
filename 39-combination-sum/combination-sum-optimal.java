// Optimal 

class Solution {
    public void getCombinationsOfSumTarget(int index, List<Integer> combination, int target, int n, int[] candidates,
            List<List<Integer>> ans) {
        if (target == 0) { // Base Case : If valid combination is found add to ans list
            ans.add(new ArrayList<>(combination));
            return;
        }
        if (target < 0 || index == n) { // no valid combination found
            return;
        }
        // Recursive Case : Include current element and decrement from target, and recurse on same index
        // (Left Recursion Tree)
        combination.add(candidates[index]);
        getCombinationsOfSumTarget(index, combination, target - candidates[index], n, candidates, ans);
        // Backtrack by removing the last added element
        // (Right Recursion Tree) Recursively call the function by excluding the element
        combination.remove(combination.size() - 1);

        getCombinationsOfSumTarget(index + 1, combination, target, n, candidates, ans);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        getCombinationsOfSumTarget(0, list, target, n, candidates, ans);
        return ans;
    }
}

// T.C => O(2^T * k) where T is the target and k is the avg length of the combination list
// S.C => O(x * k) + O(T) -------------- where x is no of combinations and k is the avg length of the combination list, O(T) is the recursion stack depth
