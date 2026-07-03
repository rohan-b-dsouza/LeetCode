class Solution {
    public int countDistinctIntegers(int[] nums) {
        int n = nums.length;
        Set<Long> st = new HashSet<>();
        for (int i = 0; i < n; i++) {
            long num = nums[i];
            st.add(num);
            boolean valid = false;
            long ans = 0;
            while (num != 0) {
                long digit = num % 10;
                ans = ans * 10 + digit;
                num = num / 10;
            }
            st.add(ans);
        }
        return st.size();
    }
}