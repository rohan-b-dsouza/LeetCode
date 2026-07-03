class Solution {
    public int countDistinctIntegers(int[] nums) {
        int n = nums.length;
        Set<Integer> st = new HashSet<>();
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            st.add(num);
            boolean valid = false;
            int ans = 0;
            while (num != 0) {
                int digit = num % 10;
                ans = ans * 10 + digit;
                num = num / 10;
            }
            st.add(ans);
        }
        return st.size();
    }
}