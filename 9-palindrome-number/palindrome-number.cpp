// Method - 2 => By reversing half of the number (More efficient)

class Solution {
public:
    bool isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int reverse_num = 0;
        while (x > reverse_num) {
            int digit = x % 10;
            reverse_num = reverse_num * 10 + digit;
            x = x / 10;
        }
        if ((x == reverse_num)|| (x == (reverse_num / 10))) return true;
        else return false;  
    }
};

// T.C => O(logN) -> {log to the base 10}
// S.C => O(1)
