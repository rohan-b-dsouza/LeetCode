class Solution {
    public long sumAndMultiply(int n) {
        long sum = 0;
        long pos = 1;
        long x = 0;
        while (n != 0) {
            int digit = n % 10;
            n = n / 10;
            if (digit == 0) continue;
            sum += digit;
            x = (digit * pos) + x;
            pos *= 10;
        }
        return (x * sum);
    }
}