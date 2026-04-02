class Solution {
    public boolean dfs(StringBuilder temp, int n, int[] cnt, String[] ans) {
        if (temp.length() == n) {
            cnt[0]--;
            if (cnt[0] == 0) {
                ans[0] = temp.toString();
                return true;
            };
            return false;
        }
        for (char ch = 'a'; ch <= 'c'; ch++) {
            if (temp.length() != 0 && temp.charAt(temp.length() - 1) == ch) continue;
            temp.append(ch);
            boolean gotKthString = dfs(temp, n, cnt, ans);
            if (gotKthString) return true;
            temp.deleteCharAt(temp.length() - 1);
        }
        return false;
    }
    public String getHappyString(int n, int k) {
        String[] ans = new String[1];
        ans[0] = "";
        int[] cnt = new int[1];
        cnt[0] = k;
        StringBuilder temp = new StringBuilder();
        dfs(temp, n, cnt, ans);
        return ans[0];
    }
}