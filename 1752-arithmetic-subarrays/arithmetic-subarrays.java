class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int m = l.length;
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            Set<Integer> temp = new HashSet<>();
            int min = Integer.MAX_VALUE; int max = Integer.MIN_VALUE;
            int n = r[i] - l[i] + 1;
            for (int j = l[i]; j <= r[i]; j++) {
                temp.add(nums[j]);
                min = Math.min(nums[j], min);
                max = Math.max(nums[j], max);
            }
            if ((max - min) % (n - 1) != 0) {
                ans.add(false);
                continue;
            }
            int d = (max - min) / (n - 1);
            if (d == 0) {
                ans.add(true);
                continue;
            }
            boolean flag = true;
            for (int k = min; k <= max; k += d) {
                if (!temp.contains(k)) {
                    flag = false;
                    break;
                }
            }
            ans.add(flag);
        }
        return ans;
    }
}