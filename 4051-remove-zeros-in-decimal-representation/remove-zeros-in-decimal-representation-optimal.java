// Optimal

class Solution {
    public long removeZeros(long n) {
        long ans = 0;
        long multiplier = 1; // Keeps track of digit position
        
        // Extract non - zero digit in each step 
        // Since this loop will extract digits from last to first therefore we require multiplier to 
        // ensure we place digits at front in the answer
        while (n > 0) {
            // Get the digit
            long digit = n % 10;
            // If it's non - zero
            if (digit != 0) {
                // Place digit at front
                ans += digit * multiplier;  
                 // Update multiplier for next non-zero digit
                multiplier *= 10;          
            }
            // Shrink the original number
            n /= 10;
        }
        // Return ans
        return ans;
    }
}

// T.C => O(log (n))
// S.C => O(1)
