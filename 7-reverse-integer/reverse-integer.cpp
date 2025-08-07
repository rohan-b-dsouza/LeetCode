class Solution {
public:
    int reverse(int x) {
        int rev = 0;
        int digit = 0;
        while (x != 0) {
            digit = x % 10; // extracting the digits
            x = x / 10; // making the number smaller
            if ((rev > INT_MAX / 10) || (rev == INT_MAX / 10 && digit > 7)) return 0; // checks for ensuring reverse number does'nt exceed 
            if ((rev < INT_MIN / 10) || (rev == INT_MIN / 10 && digit < -8)) return 0; // the range [-2^31, 2^31 - 1]
            rev = rev * 10 + digit;
        }
        return rev;
    }
};