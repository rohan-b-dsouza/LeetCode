// Brute-Force Approach  

class Solution {
    public int reversePairs(int[] nums) {
        int cnt = 0;
        int n = nums.length; 
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] > 2 * nums[j]) cnt++;
            }
        }
        return cnt;
     }
}

// T.C => O(n ^ 2)
// S.C => O(1)
