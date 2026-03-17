class Solution {
    public int[] minDistinctFreqPair(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.merge(nums[i], 1, Integer::sum);
            min1 = Math.min(min1, nums[i]);
        };
        for (int i = 0; i < n; i++) {
            if (nums[i] != min1 && map.get(nums[i]) != map.get(min1) && nums[i] < min2) {
                min2 = nums[i];
            }
        }
        if (min2 == Integer.MAX_VALUE) return new int[] {-1, -1};
        return new int[] {min1, min2};
    }
}