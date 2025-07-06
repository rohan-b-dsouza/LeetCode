class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int cnt1 = 0;
        int cnt2 = 0;
        int cand1 = -1;
        int cand2 = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == cand1) {
                cnt1++;
                
            }
            else if (nums[i] == cand2) {
                cnt2++;
            }
            else if (cnt1 == 0) {
                cnt1++;
                cand1 = nums[i];
            }
            else if (cnt2 == 0) {
                cnt2++;
                cand2 = nums[i];
            }
            
            else if (nums[i] != cand1 && nums[i] != cand2) {
                cnt1--; cnt2--;
            }
        }
        List<Integer> ans = new ArrayList<>();
        cnt1 = 0;
        cnt2 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == cand1) cnt1++;
            else if (nums[i] == cand2) cnt2++;
        }
        if (cnt1 > n / 3) ans.add(cand1);
        if (cnt2 > n / 3) ans.add(cand2);
        return ans;

    }
}