#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    bool isPalindrome(string s) {
        string str = "";
        for (int i = 0; i < s.length(); i++) {
            if (isalnum(s[i])) str += tolower(s[i]);
        }
        int n = str.length();
        int i = 0;
        while (i != n / 2) {
            if (str[i] != str[n - i - 1]) return false;
            i++;
        }
        return true;
    }
};