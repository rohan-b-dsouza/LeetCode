class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < n; i++){
            sum += nums[i];
            int reqd = sum - k;
            ans += map.getOrDefault(reqd, 0);
            map.merge(sum, 1, Integer::sum);
        }
        return ans;
    }
}