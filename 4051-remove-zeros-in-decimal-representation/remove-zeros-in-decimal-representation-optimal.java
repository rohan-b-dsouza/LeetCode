// Optimal 

class Solution {
    public long removeZeros(long n) {
        long ans = 0;
        // First get all the non-zero digits into ans
        // This will give us the reversed result as digits will be extracted from last 
        while (n > 0) {
            long digit = n % 10;
            if (digit != 0) {
            ans = ((ans * 10) + digit);
            }
            n = n / 10;  
        }
        // Stores the final answer
        long finalAns = 0;
        // Now, reverse the ans to get the required final answer
        while (ans > 0) {
            long digit = ans % 10;
            finalAns = (finalAns * 10 + digit);
            ans = ans / 10;
        }
        // Return finalAns
        return finalAns;
    }
}

// T.C => O(log (n))
// S.C => O(1)
