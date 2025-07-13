class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == divisor) return 1;
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (divisor == 1) return dividend;
        boolean sign = true;
        if (dividend < 0 && divisor > 0) sign = false;
        if (dividend >= 0 && divisor < 0) sign = false;
        long absdividend =  Math.abs((long) dividend);
        long absDivisor = Math.abs((long) divisor);
        long ans = 0;
        while (absdividend >= absDivisor) {
            int power = 0;
            while (absdividend >= (absDivisor << (power + 1))) {
                power++;
            }
            ans += (1 << power);
            absdividend -= (absDivisor << (power));
        }
        if (sign) {
            return (int) ans;
        }
        return (int) -ans;
        
    }
}