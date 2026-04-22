class Solution {
    public List<List<Integer>> findMatrix(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        int cnt = 0;
        int i = 0;
        while (cnt != n) {
            List<Integer> temp  = new ArrayList<>();
            Set<Integer> st = new HashSet<>();
            while (i < n) {
                if (cnt == n) break;
                if (nums[i] != -1 && !st.contains(nums[i])) {
                    temp.add(nums[i]);
                    st.add(nums[i]);  
                    nums[i] = -1;
                    cnt++;                  
                };
                i++;
            }
            i = 0;
            ans.add(temp);
        }
        return ans;
    }   
}