class Solution {
    public long countCommas(long n) {
        long ans = 0;
        if (n > 999L) {
            ans += Math.min(n, 999999L) - 999L; 
        }
        if (n > 999999L) {
            ans += (Math.min(n, 999999999L) - 999999L) * 1L * 2;
        } 
        if (n > 999999999L) {
            ans += (Math.min(n, 999999999999L) - 999999999L) * 1L * 3;
        } 
        if (n > 999999999999L) {
            ans += (Math.min(n, 999999999999999L) - 999999999999L) * 1L * 4;
        }
        if (n > 999999999999999L) {
            ans += (n - 999999999999999L) * 1L * 5;
        }
        return ans;
    }
}