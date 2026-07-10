class Solution {
    public boolean check(int idx, String sqr, int n, int num, int sum) {
        if (idx == n) {
            if (sum == num) {
                return true;
            }
            return false;
        }
        if (sum > num) return false;
        for (int i = idx; i < n; i++) {
            String substr = sqr.substring(idx, i + 1);
            int val = Integer.parseInt(substr);
            if (check(i + 1, sqr, n, num, sum + val)) return true;
        }
        return false;
    }
    public int punishmentNumber(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            String sqr = String.valueOf(i * i);
            if (check(0, sqr, sqr.length(), i, 0)) {
                System.out.println(i);
                ans += i * i;
            }
        }
        return ans;
    }
}