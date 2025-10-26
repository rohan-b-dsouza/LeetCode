class Solution {
    public String lexSmallest(String s) {
        int n = s.length();
        StringBuilder ans = new StringBuilder("");
        for (int i = 1; i <= n; i++) {
            StringBuilder firstK = new StringBuilder(s.substring(0, i)).reverse().append(s.substring(i));
            StringBuilder lastK = new StringBuilder(s.substring(0, n - i));
            lastK.append(new StringBuilder(s.substring(n - i)).reverse());
            if ((ans.length() == 0) || (firstK.compareTo(ans) < 0)) ans = firstK;
            if (lastK.compareTo(ans) < 0) ans = lastK;
        }
        return ans.toString();
    }
}

