class Solution {
    public boolean dfs(StringBuilder sb, int n, String[] ans, Set<String> set) {
        if (sb.length() == n) {
            String s = sb.toString();
            if (!set.contains(s)) {
                ans[0] = s;
                return true;
            }
            return false;
        }
        sb.append("0");
        if (dfs(sb, n, ans, set)) return true;
        sb.deleteCharAt(sb.length() - 1);
        sb.append("1");
        if (dfs(sb, n, ans, set)) return true;
        sb.deleteCharAt(sb.length() - 1);
        return false;
    }
    public String findDifferentBinaryString(String[] nums) {
        int n = nums.length;
        String[] ans = new String[1];
        StringBuilder sb = new StringBuilder();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }
        dfs(sb, n, ans, set);
        return ans[0];
    }
}