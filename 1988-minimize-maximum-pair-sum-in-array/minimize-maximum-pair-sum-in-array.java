class Solution {
    public int minPairSum(int[] nums) {
        int n = nums.length;
        int ans = -1;
        int[] count = new int[100001];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
            count[nums[i]]++;
        } 
        int i = min; int j = max;
        while (i <= j) {
            while (i <= max && count[i] == 0) i++;
            while (j >= min && count[j] == 0) j--;
            if (i > j) break;
            count[i]--; count[j]--;
            ans = Math.max(i + j, ans);
        }
        return ans;
    }
}