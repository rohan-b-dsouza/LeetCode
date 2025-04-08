// Optimal - Approach =>

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(i != 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                }
                else {
                    List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                    ans.add(triplet);
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j-1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
        }
        return ans;
    }
}

// T.C => O(n^2) + O(nlogn) = O(n^2)
// S.C => O(x) where x = no. of unique triplets ----{This space is only used to store and return the answer. We are not using any extra space to solve this problem. So, from that perspective, space complexity can be written as O(1).}
