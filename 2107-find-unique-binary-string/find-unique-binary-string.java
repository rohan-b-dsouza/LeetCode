class Solution {
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        Set<String> st = new HashSet<>();
        for (int i = 0; i < n; i++) {
            st.add(nums[i].toString());
        }
        StringBuilder sb = new StringBuilder(nums[0]);
        for (int i = 0; i < n; i++) {
            sb.setCharAt(i, sb.charAt(i) == '0' ? '1' : '0');
            String s = sb.toString();
            if (!st.contains(s)) return s; 
        }
        return "";
    }
}