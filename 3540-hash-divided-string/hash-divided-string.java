class Solution {
    public String stringHash(String s, int k) {
        int n = s.length();
        int cnt = 0;
        int hashedChar = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= n; i ++) {
            if (cnt == k) {
                sb.append((char) ((hashedChar % 26) + 'a'));
                hashedChar = 0;
                cnt = 0;
            }
            if (i == n) break;
            hashedChar += s.charAt(i) - 'a';
            cnt++;
        }
        return sb.toString();
    }
}