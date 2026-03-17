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
        for (int key: map.keySet()) {
            if (map.get(key) != map.get(min1) && key < min2) {
                min2 = key;
            }
        }
        if (min2 == Integer.MAX_VALUE) return new int[] {-1, -1};
        return new int[] {min1, min2};
    }
}