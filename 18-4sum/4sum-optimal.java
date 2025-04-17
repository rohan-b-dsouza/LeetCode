// Optimal - Approach (Sorting + Two Pointer Approach) => 

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int N = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < N; i++) {
            if (i != 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < N; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1])
                    continue;
                int k = j + 1;
                int l = N - 1;
                while (k < l) {
                    long sum = (long) nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum < target) {
                        k++;
                    } else if (sum > target) {
                        l--;
                    } else {
                        List<Integer> quad = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                        ans.add(quad);
                        k++;
                        l--;
                        while (k < l && nums[k] == nums[k - 1]) {
                            k++;
                        }
                        while (k < l && nums[l] == nums[l + 1]) {
                            l--;
                        }
                    }
                }
            }
        }
        return ans;
    }
}

// T.C => O(nlogn) + O(n^3) = O(n^3)
// S.C => O(x) where x = no. of unique quadraplets, but this space is used to return the ans not to solve the problem so from that perspective S.C = O(1)
