class Solution {
public:
    bool isPalindrome(int x) {
        if (x < 0) return false; // eg. as given in example 2 in leetcode qn 9
        int original = x, digit = 0;
        int rev = 0;
        while (x != 0) {
            digit = x % 10; // extracting the digits
            x = x / 10; // making the number smaller
            if ((rev > INT_MAX / 10) || (rev == INT_MAX / 10 && digit > 7)) return 0; // checks for ensuring reverse number does'nt exceed 
            if ((rev < INT_MIN / 10) || (rev == INT_MIN / 10 && digit < -8)) return 0; // the range [-2^31, 2^31 - 1]
            rev = rev * 10 + digit;
        }
        if (original == rev) return true;
        return false;
    }
};
