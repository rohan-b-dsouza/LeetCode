class Solution {
    public int countElements(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;
        int i = 0;
        int freq = 1;
        while (i < n) {
            if (i == n - 1 || nums[i] != nums[i + 1]) {
                int greater = n - i - 1;
                if (greater >= k) {
                    ans += freq;
                    freq = 1;
            }
            }
            else {
                freq++;
            }
            i++;
        }
        return ans;
    }
}