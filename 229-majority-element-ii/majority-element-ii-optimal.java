// Optimal - Approach 

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int cnt1 = 0;
        int cnt2 = 0;
        int candidate1 = Integer.MIN_VALUE;
        int candidate2 = Integer.MIN_VALUE;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (cnt1 == 0 && nums[i] != candidate2) {
                cnt1 = 1;
                candidate1 = nums[i]; 
            }
            else if (cnt2 == 0 && nums[i] != candidate1) {
                cnt2 = 1;
                candidate2 = nums[i];
            }
            else if(nums[i] == candidate1) {
                cnt1++;
            }
            else if(nums[i] == candidate2) {
                cnt2++;
            }
            else {
                cnt1--;
                cnt2--;
            }
        }
        cnt1 = 0;
        cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == candidate1) cnt1++;
            if (nums[i] == candidate2) cnt2++;
        }
        if (cnt1 > n  / 3) ans.add(candidate1);
        if (cnt2 > n / 3) ans.add(candidate2);
        return ans;
    }
}

// T.C => O(2n) => O(n)
// S.C => O(2) => O(1) as a list of size 2 is reqd, though its not reqd to solve problem but only to return the answer.
