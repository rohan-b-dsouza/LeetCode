// Optimal 

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
        int ans = 0;
        while (absdividend >= absDivisor) {
            int power = 0;
            while (absdividend >= (absDivisor << (power + 1))) {
                power++;
            }
            ans += (1 << power);
            absdividend -= (absDivisor << (power));
        }
        if (sign) {
            return ans;
        }
        return -ans;
        
    }
}

// Time Complexity:
// Worst-case: O((log N)^2), due to nested loop where both outer and inner loops can go up to log N
// Amortized: O(log N), because dividend is reduced exponentially, and total number of inner iterations is bounded

// Space Complexity:
// O(1) – uses constant extra space
