class Solution {
    public boolean hasAlternatingBits(int n) {
        int rightShiftBy1 = n >> 1;
        int xor = n ^ rightShiftBy1;
        if ((xor & (xor + 1)) == 0) return true;
        return false; 
}}