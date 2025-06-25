// Optimal

class Solution {
    public int upperBound(int[] arr, int target) {
        
        int ans = arr.length;
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
        int mid = (low + high) / 2;

        if (arr[mid] > target) {
            ans = mid;
            
            high = mid - 1;
        }
        else {
            low = mid + 1; 
    }
        
        
   }
        return ans;
    }
    public void getPowerSet(int index, List<Integer> subset, List<List<Integer>> ans,  int n, int[] nums) {
      if (index == n) { // Base Case :- Add subset to the ans list
        ans.add(new ArrayList<>(subset));
        return;
      }
      // Recursively include current element in the subset
      subset.add(nums[index]); 
      getPowerSet(index + 1, subset, ans, n, nums);
      // Backtrack by removing last added element
      subset.remove(subset.size() -1 );
      // Recursively exclude current element from the subset
      // Use upperBound to skip duplicates in order to ensure unique subsets in final 'ans' list
      getPowerSet(upperBound(nums, nums[index]), subset, ans, n, nums);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
      Arrays.sort(nums);
      int n = nums.length;
      List<List<Integer>> ans = new ArrayList<>();
      List<Integer> subset = new ArrayList<>();
      getPowerSet(0, subset, ans, n, nums);
      return ans;
    }
}

// T.C => O(2^n * n) -------{2^n as there are two choices for each element & n for copying list at base case (n is worst case length of a subset)}
// S.C => O(n) + O(x * n) = O(n) ---------------- {where O(n) is reqd for recursion stack, x is no. of unique combinations and n is  len of subset in worst case, we can neglect O(x * n) as its reqd for output not for solving the qn}
