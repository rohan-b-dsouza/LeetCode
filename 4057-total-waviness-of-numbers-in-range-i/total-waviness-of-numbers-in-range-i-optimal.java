// Optimal
// Solve the Problem:- 3753. Total Waviness of Numbers in Range II which is a 'Hard' version of this problem which requires the topic 'Digit DP'

class Solution {
    public int waviness(int num) {
        // Get the String Representation of the number
        String a = String.valueOf(num);
        // Set sum to 0
        int sum = 0;
        // Iterate over the digits of the number
        for (int i = 1; i < a.length() - 1; i++) {
            // If the number is strictly greater than its neighbours or strictly smaller than its neighbours, then increment sum
            if ((a.charAt(i) > a.charAt(i - 1) && a.charAt(i) > a.charAt(i + 1))
                    || (a.charAt(i) < a.charAt(i - 1) && a.charAt(i) < a.charAt(i + 1))) {
                sum++;
            }
        }
        // Return sum
        return sum;
    }
    
    public int totalWaviness(int num1, int num2) {
        int sum = 0;
        // For all the numbers in the range
        for (int i = num1; i <= num2; i++) {
            // Accumulate the waviness
            sum += waviness(i);
        }
        // Return waviness sum
        return sum;
    }
}

// T.C => O(4 * n) = O(n) as in the worst case i.e 10^5 number we will require 4 operations to calculate waviness
// S.C => O(6) = O(1) as in worst case String can hold the number 10^5 i.e 100000
