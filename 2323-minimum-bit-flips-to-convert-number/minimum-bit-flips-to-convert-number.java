class Solution {
    public int minBitFlips(int start, int goal) {
        int ans = start ^ goal;
        int cntBits = 0;
        while (ans != 0) {
            cntBits += ans & 1;
            ans = ans >> 1; 
        }
        return cntBits;
    }
}