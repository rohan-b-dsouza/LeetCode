class Solution {
    public void dfs(String tiles, Set<String> st, StringBuilder temp, boolean[] used, int n) {
        st.add(temp.toString());

        for (int i = 0; i < n; i++) {
            if (used[i]) continue;
            used[i] = true;
            temp.append(tiles.charAt(i));
            dfs(tiles, st, temp, used, n);
            used[i] = false;
            temp.deleteCharAt(temp.length() - 1);
        }
    }
    public int numTilePossibilities(String tiles) {
        int n = tiles.length();
        Set<String> st = new HashSet<>();
        StringBuilder temp = new StringBuilder();
        boolean[] used = new boolean[n];
        dfs(tiles, st, temp, used, n);
        return st.size() - 1;
    }
}