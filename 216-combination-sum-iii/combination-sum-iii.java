// Optimal

class Solution {
    public void getValidcombinations(int lastElement, int sum,  int k, List<Integer> combination, List<List<Integer>> ans) {
        // Base Case : // If subset of sum n with size k found, add to ans
        // Even if sum ≠ 0, we return early once size == k
        // This avoids generating invalid k+1 length subsets (prunes unnecessary calls)
        if (combination.size() == k) { 
            if (sum == 0) { 
                ans.add(new ArrayList<>(combination));
            }
            return; 
        }
        // valid subset means subset of sum 'n' provided in qn
        for (int i = lastElement; i <= 9; i++) { // Iterate from the last occured number to 9 
            // Pruning : If current number is less than or equal to sum, then only recurse otherwise break avoiding unncessary recursive calls
            if (i <= sum) { 
                combination.add(i);
                getValidcombinations(i + 1, sum - i, k, combination, ans);
                combination.remove(combination.size() - 1);
            }
            else {
                break;
            }
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        getValidcombinations(1, n, k, combination, ans);
        return ans;
    }
}

// T.C => O(C(9,k) * k) as we are selecting k distinct nos from 1 to 9.
// S.C => O(k) + O(C(9,k) * k) + O(k) ---------{Here, for solving the problem only O(k) is reqd, hence O(C(9,k) * k) reqd for result storage can be ignored but mention this in interviews}
