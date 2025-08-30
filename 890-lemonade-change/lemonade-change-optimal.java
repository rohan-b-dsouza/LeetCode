// Optimal

class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;

        for (int bill : bills) {
            // If $5 bill → just increment five
            if (bill == 5) {
                five++;
            }
            // If $10 bill → need one $5 as change
            else if (bill == 10) {
                if (five > 0) {
                    five--;
                    ten++;
                } else {
                    return false;
                }
            }
            // If $20 bill → need $15 change
            else {
                // Greedy step: prefer giving $10 + $5 (if possible)
                if (ten > 0 && five > 0) {
                    ten--;
                    five--;
                }
                // Otherwise, fall back to 3 fives
                else if (five >= 3) {
                    five -= 3;
                } 
                else {
                    return false;
                }
            }
        }
        return true;
    }
}

// T.C => O(n)   (process each bill once)
// S.C => O(1)   (just counters)

// Greedy approach:
// When a $20 comes, there are 2 ways to give back $15:
//   Option A → $10 + $5
//   Option B → $5 + $5 + $5
// The greedy choice is to always give $10 + $5 if possible,
// because $5 bills are more critical (needed for $10 customers too).
// This local choice ensures the global optimum.
