// Optimal

// Logic:- For each subarray check if its sum is present in that subarray as an element. This can be done using a nested loop with set and running sum.
// For each subarray add the current element to the sum and the set. Check if the sum exists in the set, if yes increment counter 'ans'

class Solution {
    public int centeredSubarrays(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            Set<Integer> st = new HashSet<>();
            for (int j = i; j < n; j++) {
                st.add(nums[j]);
                sum += nums[j];
                if (st.contains(sum)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}

// T.C => O(n ^ 2)
// S.C => O(n)
