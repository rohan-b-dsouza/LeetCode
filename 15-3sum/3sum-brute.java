// Brtue - Force Approach =>

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        HashSet<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        triplet.sort(null); // O(3log3)
                        set.add(triplet);
                    }
                }
            }
        }
        // for (List<Integer> tripl : set) {
        //     ans.add(tripl);
        // }
        // or ans.addAll(set);
        //or =>
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }
}

// T.C => O(n^3) + O(3log3) = O(n^3) + O(1) => O(n^3)
// S.C => O(2*x) = O(x) where x = no. of unique triplets -> as we are using a set data structure and a list to store the triplets.
