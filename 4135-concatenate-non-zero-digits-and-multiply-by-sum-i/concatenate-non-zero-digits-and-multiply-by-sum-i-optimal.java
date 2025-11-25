// Optimal

class Solution {
    public long sumAndMultiply(int n) {
        // Set sum, pos and x to 0
        long sum = 0;
        // Pos is used to append the digits at the front to avoid reversal once we get the number
        long pos = 1;
        long x = 0;
        // While n is not zero
        while (n != 0) {
            // Get the last digit
            int digit = n % 10;
            // Remove the last digit in n
            n = n / 10;
            // If digit is 0, skip
            if (digit == 0) continue;
            // Add digit to sum
            sum += digit;
            // Update x by appending the digit to the front
            x = (digit * pos) + x;
            // Multiply pos by 10
            pos *= 10;
        }
        // Return the required result
        return (x * sum);
    }
}

// T.C => O(log(n))
// S.C => O(1)
