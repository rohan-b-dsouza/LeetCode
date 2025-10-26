// Optimal (Greedy)

class Solution {
    public String maxSumOfSquares(int num, int sum) {
        // To keep track of the sum so far
        int runningSum = 0;
        // Stores the answer
        StringBuilder ans = new StringBuilder();
        // Loop to get all num digits greedily (Greedy Approach : In each step, we append the largest digit possible)
        for (int i = 1; i <= num; i++) {
            // Take minimum of (9, remaining sum reqd) to ensure we take the largest digit
            int digit = Math.min(9, sum - runningSum);
            // Add this digit to runningSum
            runningSum += digit;
            // Append this digit to ans
            ans.append((char) (digit + '0'));
        }
        // If the digits of the result do not sum to 'sum' then return empty string, else return ans as a string
        return (runningSum == sum) ? ans.toString() : "";
    }
}

// T.C => O(n)
// S.C => O(1) --------{O(n) for StringBuilder is neglected as thats reqd for output space}
