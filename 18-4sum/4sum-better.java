// Better - Approach =>

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        HashSet<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                HashSet<Long> hash = new HashSet<>();
                for (int k = j + 1; k < n; k++) {
                    long fourth = (long)target - nums[i] - nums[j] - nums[k];

                    if (hash.contains(fourth)) {
                        List<Integer> quad = Arrays.asList(nums[i], nums[j], nums[k], (int)fourth);
                        quad.sort(null);
                        set.add(quad);
                    }
                    hash.add((long)nums[k]);
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }
}

// T.C => O(n^3)
// S.C => O(x) + O(n) + O(x) => O(x + n) => O(max(n,x)) ---------{ here, the list 'ans' is used only to return the ans not to solve the problem therefore we dont consider it in the final space complexity)
