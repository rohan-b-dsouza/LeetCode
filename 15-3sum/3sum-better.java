// Better - Approach =>

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        HashSet<List<Integer>> set = new HashSet<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int target = -nums[i];
            HashSet<Integer> hash = new HashSet<>();
            for (int j = i + 1; j < n; j++) {
                int moreneeded = target - nums[j];
                if (hash.contains(moreneeded)) {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], moreneeded);
                    triplet.sort(null);
                    set.add(triplet);
                }
                hash.add(nums[j]);
            }
        }
        List<List<Integer>> ans = new ArrayList<>(set);
        return ans;
    }

}

// T.C => O(n^2) + O(3log3) = O(n^2) + O(1) => O(n^2)
// S.C => O(x) + O(n) + O(x) = O(2*x) => O(x) as we are using a set data structure and a list to store the triplets and extra O(n) for storing the array elements in another set in every iteration.(maximum in any iteration n elements can be stored in the hash therefore we consider O(n))
// But the list is used only to return the ans thereforce S.C = O(n + x) = O(max(n, x)).
