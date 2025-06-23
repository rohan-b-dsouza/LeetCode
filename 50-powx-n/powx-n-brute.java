// Brute

class Solution {
    public double myPow(double x, int n) {
        if (n == 0 || x == 1) return 1; // base case : any no to the power 0 is itself and 1 raised to anything is 1
        long temp = n; 
        if (n < 0) { // handle negative exponents
            x = 1 / x;
            temp = -temp; // if n = -2,147,483,648, its -n = 2,147,483,648 which overflows int therefore use long
        }
        double ans = 1;
        for (long i = 0; i < temp; i++) {
            ans *= x;
        }
    return ans;
    }
}

// T.C => O(n)
// S.C => O(1)
