class Solution {
public:
    bool isPalindrome(int x) {
        if (x < 0) return false; // as given in example 2 in leetcode qn 9
        int original = x, digit = 0;
        long long rev = 0; // using long long as reverse number can exceed the int range for larger int values(x) as
                           // constraints for x are [-2^31 <= x <= 2^31 - 1]
        while (x != 0) {
            digit = x % 10; // extracting the digits
            x = x / 10; // making the number smaller
            rev = rev * 10 + digit;
        }
        if (original == rev) return true;
        return false;
    }
};
