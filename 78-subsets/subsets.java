class Solution {
    public void generateSubsets(int index, List<Integer> list, List<List<Integer>> ans, int n, int[] nums) {
        // Base case : If the index reaches array length, add curr subset to answer
        if (index == n) { 
            ans.add(new ArrayList<>(list));
            return;
        }
        // Include curr element in the subset, and move to the next element
        list.add(nums[index]); 
        // Recursive Case (Left Recursion tree) : Go on including elements  
        generateSubsets(index + 1, list, ans, n, nums); 
         // Backtrack : Remove the last added element to explore other subsets
        list.remove(list.size() - 1);
        // Recursive Case (Right Recursion tree) : Go on excluding the elements
        generateSubsets(index + 1, list, ans, n, nums);
    }
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        generateSubsets(0, list, ans, n, nums);
        return ans;
    }
}