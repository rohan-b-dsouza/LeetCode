class Solution {
    public boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        int five = 0;
        int ten = 0;
        for (int i = 0; i < n; i++) {
            // If $5 bill then just increment five
            if (bills[i] == 5) {
                five++;
            }
            // if $10 bill then increment ten decrement five, if a $5 is available for change
            else if (bills[i] == 10) {
                if (five != 0) {
                    five--;
                    ten++;
                }
                else return false;
            }
            else {
                // if $20 bill then first check if a change of {$10 + $5} is possible if not then check if 
                // {$5 + $5 + $5} is possible, this is where we use the greedy approach
                if (ten != 0 && five != 0) {
                    ten--;
                    five--;
                }
                else if (five >= 3) {
                    five-=3;
                }
                else return false;
            }
        }
        return true;
    }
}

// T.C => O(n)
// S.C => O(1)

// Greedy approach:

// At every step, when a customer gives $20, you must decide how to give back $15.

// Option A → $10 + $5

// Option B → $5 + $5 + $5

// \U0001f449 The greedy choice is:
// Always give $10 + $5 if possible.
// Only if that’s not possible, fall back to 3 x $5.

// Why is this greedy?

// Because we’re locally optimizing: saving more $5s for the future, since $5s are the most critical for giving change.

// We don’t “look ahead” at the rest of the array, we just pick the best option right now.

// And this local choice leads to a global optimum (never failing to give change unless it’s truly impossible).