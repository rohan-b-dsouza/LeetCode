class Solution {
    public int[] minDistinctFreqPair(int[] nums) {
        int n = nums.length;
        int[] ans = new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.merge(nums[i], 1, Integer::sum);
        }
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            for (int j = 0; j < n; j++) {
                int y = nums[j];
                if (i == j || x >= y || map.get(x) == map.get(y)) continue;
                if (x < ans[0]) {
                    ans[0] = x;
                    ans[1] = y;
                }
                else if (x == ans[0] && y < ans[1]) {
                    ans[0] = x;
                    ans[1] = y;
                }
            }
        }
        if (ans[0] == Integer.MAX_VALUE) {
            ans[0] = ans[1] = -1;
        } 
        return ans;
    }
}