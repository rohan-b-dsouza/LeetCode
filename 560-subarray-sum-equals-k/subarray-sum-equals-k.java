class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int runsum = 0;
        int ans = 0;
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            runsum += nums[i];
            ans += map.getOrDefault(runsum - k, 0);
            map.merge(runsum, 1, Integer::sum);
        }
        return ans;
    }
}