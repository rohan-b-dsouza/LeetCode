// Brute

class Solution {
    public int minBitFlips(int start, int goal) {
        int ans = start ^ goal;
        int cntBits = 0;
        for (int i = 0; i <= 31; i++) {
            if ((ans & (1 << i)) != 0) {
                cntBits++;
            }
        }
        return cntBits;
    }
}

// T.C => O(31)
// S.C => O(1)
