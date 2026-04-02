class Solution {
    public void dfs(int n, StringBuilder temp, List<String> ans) {
        if (temp.length() == n) {
            ans.add(temp.toString());
            return;
        }
        if (temp.length() != 0) {
            char ch = temp.charAt(temp.length() - 1);
            if (ch == '0') {
                temp.append('1');
                dfs(n, temp, ans);
                temp.deleteCharAt(temp.length() - 1);
            } else {
                temp.append('0');
                dfs(n, temp, ans);
                temp.deleteCharAt(temp.length() - 1);
                temp.append('1');
                dfs(n, temp, ans);
                temp.deleteCharAt(temp.length() - 1);
            }
        } else {
            temp.append('0');
            dfs(n, temp, ans);
            temp.deleteCharAt(temp.length() - 1);
            temp.append('1');
            dfs(n, temp, ans);
            temp.deleteCharAt(temp.length() - 1);
        }

    }

    public List<String> validStrings(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        dfs(n, temp, ans);
        return ans;
    }
}