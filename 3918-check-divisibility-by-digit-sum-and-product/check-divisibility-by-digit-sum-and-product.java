class Solution {
    public boolean checkDivisibility(int n) {
        long digsum = 0;
        long prod = 1;
        int original = n;
        while (n != 0) {
            int digit = n % 10;
            digsum+=digit;
            prod *= digit;
            n = n / 10;
        }
        if (original % (digsum + prod) == 0) {
            return true;
        }
        return false;
    } 
}