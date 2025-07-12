// Better - 2 (Better than Better - 2)

class Solution {
    public int minBitFlips(int start, int goal) {
        int ans = start ^ goal;
        int cntBits = 0;
        while (ans != 0) {
            cntBits++;
            ans = ans & (ans - 1);
        }
        return cntBits;
    }
}

// T.C => O(k) where k is no. of set bits
// S.C => O(1)
