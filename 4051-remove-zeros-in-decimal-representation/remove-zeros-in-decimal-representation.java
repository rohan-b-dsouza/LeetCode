class Solution {
    public long getPower(long base, long expo) {
        long ans = 1;
        while (expo > 0) {
            if (expo % 2 == 0) {
                expo /= 2;
                base = base * base;
            }
            else {
                expo--;
                ans = ans * base;
            }
        }
        return ans;
    }
    public long removeZeros(long n) {
        long ans = 0;
        long cnt = 0;
        while (n > 0) {
            long digit = n % 10;
            if (digit != 0) {
            ans = (digit * getPower(10, cnt) + ans);
            cnt++;
            }
            n = n / 10;  
        }
        return ans;
    }
}