class Solution {
    public void dfs(StringBuilder temp, int n, int k, List<String> happyStrings) {
        if (temp.length() == n) {
            happyStrings.add(temp.toString());
            return;
        }
        for (char ch = 'a'; ch <= 'c'; ch++) {
            if (temp.length() != 0 && temp.charAt(temp.length() - 1) == ch) continue;
            temp.append(ch);
            dfs(temp, n, k, happyStrings);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
    public String getHappyString(int n, int k) {
        List<String> happyStrings = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        dfs(temp, n, k, happyStrings);
        happyStrings.sort(null);
        return happyStrings.size() < k ? "" : happyStrings.get(k - 1);
    }
}