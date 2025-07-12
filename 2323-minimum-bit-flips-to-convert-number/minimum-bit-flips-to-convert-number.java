// Optimal

class Solution {
    public int minBitFlips(int start, int goal) {
        int ans = start ^ goal;
        return Integer.bitCount(ans);
    }
}

// T.C => O(1)
// S.C => O(1)
