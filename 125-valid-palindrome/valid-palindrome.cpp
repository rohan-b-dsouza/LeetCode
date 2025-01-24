class Solution {
public:
    bool isPal(string &str, int i) {
        if (i >= str.length() / 2) return true;
        if (tolower(str[i]) != tolower(str[str.length() - 1 - i])) return false;
        return isPal(str, i + 1);
    }

    bool isPalindrome(string s) {
        string str = "";
        for (int i = 0; i < s.length(); i++) {
            if (isalnum(s[i])) str += s[i];
        }
        return isPal(str, 0);

    }
};