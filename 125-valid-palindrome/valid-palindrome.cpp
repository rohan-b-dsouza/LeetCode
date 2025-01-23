class Solution {
public:
    bool isPal(string &str, int i, int j) {
        if (i >= j) return true;
        if (tolower(str[i]) != tolower(str[j])) return false;
        return isPal(str, i + 1, j - 1);
    }

    bool isPalindrome(string s) {
        string str = "";
        for (int i = 0; i < s.length(); i++) {
            if (isalnum(s[i])) str += s[i];
        }
        return isPal(str, 0, str.length() - 1);

    }
};