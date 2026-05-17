class Solution {
    public void dfs(String tiles, int[] freq, int n, int[] ans) {
        ans[0]++;

        for (int i = 0; i < 26; i++) {
            if (freq[i] == 0) continue;
            freq[i]--;
            dfs(tiles, freq, n, ans);
            freq[i]++;
        }
    }
    public int numTilePossibilities(String tiles) {
        int n = tiles.length();
        StringBuilder temp = new StringBuilder();
        int[] freq = new int[26];
        for (int i = 0; i < n; i++) {
            freq[tiles.charAt(i) - 'A']++;
        }
        int[] ans = new int[1];
        dfs(tiles, freq, n, ans);
        return ans[0] - 1;
    }
}