class Solution {
    public boolean check(int curr, int num, int sum) {
        if (curr == 0) {
            if (sum == num) {
                return true;
            }
            return false;
        }
        if (sum > num) return false;
        return check(curr / 10, num, sum + curr % 10) || check(curr / 100, num, sum + curr % 100) || check(curr / 1000, num, sum + curr % 1000) || check(curr / 10000, num, sum + curr % 10000);
    }
    public int punishmentNumber(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (check(i * i, i, 0)) {
                ans += i * i;
            }
        }
        return ans;
    }
}