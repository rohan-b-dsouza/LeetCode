// Optimal

class Solution {
    public int minimumFlips(int n) {
        // Get the length of the binary rep of n
        int len = 32 - Integer.numberOfLeadingZeros(n);
        // Set L to len - 1 and R to 0
        int L = len - 1;
        int R = 0;
        int res = 0;
        // While L > R
        while (L > R) {
            // Get the leftmost bit
            int leftBit = (n >> L) & 1;
            // Get the rightmost bit
            int rightBit = (n >> R) & 1;
            // If they are not equal, it means we need to flip these two bits hence add 2 to the answer
            if (leftBit != rightBit) {
                res+=2;
            }
            // Decrement L, Increment R
            L--;
            R++;
        }
        // Return res
        return res;
    }
}

// T.C => O(log (n)) as a number n has log (n) bits
// S.C => O(1)
