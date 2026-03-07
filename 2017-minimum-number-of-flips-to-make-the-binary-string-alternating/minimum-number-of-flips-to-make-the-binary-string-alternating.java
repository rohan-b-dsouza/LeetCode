class Solution {
    public int minFlips(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        sb.append(s);
        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        for (int i = 0; i < 2 * n; i++) {
            s1.append((i % 2 == 0) ? '0' : '1');
            s2.append((i % 2 == 0) ? '1' : '0');
        }
        int i = 0;
        int j = 0;
        int flip1 = 0;
        int flip2 = 0;
        int ans = Integer.MAX_VALUE;
        while (j < 2 * n - 1) {
            if (sb.charAt(j) != s1.charAt(j)) {
                flip1++;
            }
            if (sb.charAt(j) != s2.charAt(j)) {
                flip2++;
            }
            if (j - i + 1 >= n) {
                ans = Math.min(flip1, Math.min(flip2, ans));
                if (sb.charAt(i) != s1.charAt(i)) flip1 -= 1;
                if (sb.charAt(i) != s2.charAt(i)) flip2 -= 1;
                i++;
            }
            j++;
        }
        return ans;
    }
}