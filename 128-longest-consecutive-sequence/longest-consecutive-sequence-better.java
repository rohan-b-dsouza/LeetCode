// Better Solution

class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Arrays.sort(nums);
        int cnt = 1;
        int maxcnt = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                cnt++;
                maxcnt = Math.max(maxcnt, cnt);
            }
            else if (nums[i] - nums[i - 1] == 0){
                continue;
            }
            else {
                cnt = 1;
            }
        }
        return maxcnt;
    }
}

// T.C => O(nlog(n))
// S.C => O(1)
