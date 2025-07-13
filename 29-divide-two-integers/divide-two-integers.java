class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == divisor) return 1;
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if(divisor == 1) return dividend;
        boolean sign = true;
        if (dividend < 0 && divisor > 0) sign = false;
        if (dividend >= 0 && divisor < 0) sign = false;
        long absDivisor = Math.abs((long) divisor);
        long absDividend = Math.abs((long) dividend);
        long cnt = 0;
        long sum = absDivisor;
        while (absDividend >= sum) {
            cnt++;
            sum += absDivisor;
        }
        if (sign) {
            return (int) cnt;
        }
        return (int) -cnt;
    }
}