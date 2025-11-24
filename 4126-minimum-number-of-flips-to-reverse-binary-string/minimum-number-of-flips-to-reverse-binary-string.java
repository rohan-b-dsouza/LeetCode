class Solution {
    public int minimumFlips(int n) {
        int len = 32 - Integer.numberOfLeadingZeros(n);
        int L = len - 1;
        int R = 0;
        int res = 0;
        while (L > R) {
            int leftBit = (n >> L) & 1;
            int rightBit = (n >> R) & 1;
            if (leftBit != rightBit) {
                res+=2;
            }
            L--;
            R++;
        }
        return res;
    }
}