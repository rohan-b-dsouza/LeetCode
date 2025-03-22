// Brute-Force Solution

class Solution {
    public boolean linearSearch(int[] nums, int key) {

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key)
                return true;
        }
        return false;
    }

    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        int maxcnt = 1;
        for (int i = 0; i < nums.length; i++) {
               int cnt = 1;
               int x = nums[i];
                while (linearSearch(nums, (x + 1)) == true) {
                    cnt++;
                    x++;
                }
                maxcnt = Math.max(maxcnt, cnt);
        }return maxcnt;
}}

// T.C => O(n^2)
// S.C => O(1)
