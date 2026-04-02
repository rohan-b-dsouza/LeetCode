class Solution {
    public void dfs(int n, StringBuilder temp, List<String> ans) {
        if (temp.length() == n) {
            ans.add(temp.toString());
            return;
        }
        temp.append('1');
        dfs(n, temp, ans);
        temp.deleteCharAt(temp.length() - 1);
        if (temp.length() == 0 || temp.charAt(temp.length() - 1) == '1') {
            temp.append('0');
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