class Solution {
    public long removeZeros(long n) {
        long ans = 0;
        long multiplier = 1; // Keeps track of digit position
        
        // Process digits from least significant to most
        while (n > 0) {
            long digit = n % 10;
            if (digit != 0) {
                ans += digit * multiplier;  // Place digit in correct position
                multiplier *= 10;           // Update multiplier for next non-zero digit
            }
            n /= 10;
        }
        
        return ans;
    }
}
