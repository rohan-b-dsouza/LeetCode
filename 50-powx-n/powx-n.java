class Solution {
  public double power(double x, long n) {
    if (n == 0) return 1; // base condition

    if (n == 1) return x; // anything raised to 1 is itself

    if (n % 2 == 0) { // if n is even
      return power(x * x, n / 2); // recursive call : x*x, n / 2
    }
    // if n is odd
    return x * power(x, n - 1); // recursive call x * power(x, n - 1);
  }

  public double myPow(double x, int n) {
    if (n < 0) {
      return 1 / power(x,  - (long)n);
    }
    return power(x, n);
  }
}


















// class Solution {
//     public double myPow(double x, int n) {
//         if (n == 0 || x == 1) return 1; // base case : any no to the power 0 is itself and 1 raised to anything is 1
//         long temp = n; 
//         if (n < 0) { // handle negative exponents
//             x = 1 / x;
//             temp = -temp; // if n = -2,147,483,648, its -n = 2,147,483,648 which overflows int therefore use long
//         }
//         double ans = 1;
//         for (long i = 0; i < temp; i++) {
//             ans *= x;
//         }
//     return ans;
//     }
// }