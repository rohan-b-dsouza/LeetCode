class Solution {
    public long removeZeros(long n) {
        long ans = 0;
        long cnt = 0;
        while (n > 0) {
            long digit = n % 10;
            if (digit != 0) {
            ans = ((ans * 10) + digit);
            cnt++;
            }
            n = n / 10;  
        }
        long finalAns = 0;
        while (ans > 0) {
            long digit = ans % 10;
            finalAns = (finalAns * 10 + digit);
            ans = ans / 10;
        }
        return finalAns;
    }
}