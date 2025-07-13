// Brute

class Solution {    
    public int[] singleNumber(int[] nums) {        
        int[] ans = new int[2];
        int n = nums.length;
        int idx = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (nums[j] == nums[i]) cnt++;
            }
            if (cnt == 1) {
                ans[idx++] = nums[i];
            }
        }
Arrays.sort(ans);
        return ans;
    }

}

// T.C => O(n ^ 2)
// S.C => O(1)
