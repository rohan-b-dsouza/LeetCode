class Solution {
    public boolean hasAlternatingBits(int n) {
    int bit = n & 1;
    n = n >> 1;
    while (n > 0) {
        if ((n & 1) == bit) return false;
        bit = n & 1;
        n = n >> 1;
    }
    return true;
}}