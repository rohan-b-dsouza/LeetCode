// Optimal (Recursive)

class Solution {
    public double power(double x, long n) {
        if (n == 0)
            return 1; // base condition

        if (n == 1)
            return x; // anything raised to 1 is itself

        if (n % 2 == 0) { // if n is even
            return power(x * x, n / 2); // recursive call : x*x, n / 2
        }
        // if n is odd
        return x * power(x, n - 1); // recursive call x * power(x, n - 1);
    }

    public double myPow(double x, int n) {
        if (n < 0) {
            return 1 / power(x, -(long) n); // if n = -2,147,483,648, its -n = 2,147,483,648 which overflows int therefore use long
        }
        return power(x, n);
    }
}


// T.C => O(log (n)) as in almost each step we do '/ 2'
// S.C => O(log (n)) due to recursive call stack depth -------{due to log (n) no of calls}
