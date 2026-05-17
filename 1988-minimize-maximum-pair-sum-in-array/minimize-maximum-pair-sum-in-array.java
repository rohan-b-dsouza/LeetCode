class Solution {
    public int minPairSum(int[] nums) {
        int n = nums.length;
        int ans = -1;
        int[] count = new int[100001];
        for (int i = 0; i < n; i++) {
            count[nums[i]]++;
        } 
        int i = 1; int j = 100000;
        while (i <= j) {
            while (i <= 100000 && count[i] == 0) i++;
            while (j >=0 && count[j] == 0) j--;
            if (i > j) break;
            count[i]--; count[j]--;
            ans = Math.max(i + j, ans);
        }
        return ans;
    }
}