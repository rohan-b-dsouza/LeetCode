class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        int n = nums.length;
        int m = l.length;
        List<Boolean> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = l[i]; j <= r[i]; j++) {
                temp.add(nums[j]);
            }
            temp.sort(null);
            boolean flag = true;
            for (int k = 2; k < (r[i] - l[i] + 1); k++) {
                if ((temp.get(k) - temp.get(k - 1)) != (temp.get(1) - temp.get(0))) {
                    flag = false;
                    break;
                }
            }
            ans.add(flag);
        }
        return ans;
    }
}