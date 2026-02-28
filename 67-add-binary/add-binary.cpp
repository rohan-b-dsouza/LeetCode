class Solution {
public:
    string addBinary(string a, string b) {
        char carry = '0';
        string s = "";
        int i = a.size() - 1;
        int j = b.size() - 1;
        while (i >= 0 && j >= 0) {
            if (a[i] == '0' && b[j] == '0') {
                s.push_back(carry);
                if (carry == '1') carry = '0';

            }
            else if (a[i] == '1' && b[j] == '1') {
                if (carry == '1') {
                    s.push_back('1');
                }
                else {
                    s.push_back('0');
                    carry = '1';
                }
            }
            else {
                if (carry == '0') {
                    s.push_back('1');
                }
                else {
                    s.push_back('0');
                    carry = '1';
                }
            }
            i--; j--;
        }
        while (i >= 0) {
            if (carry == '1') {
                if (a[i] == '1') {
                    s.push_back('0');
                    carry = '1';
                }
                else {
                    s.push_back('1');
                    carry = '0';
                }
            }
            else {
                s.push_back(a[i]);
            }
            i--;
        } 
        while (j >= 0) {
            if (carry == '1') {
                if (b[j] == '1') {
                    s.push_back('0');
                    carry = '1';
                }
                else {
                    s.push_back('1');
                    carry = '0';
                }
            }
            else {
                s.push_back(b[j]);
            }
            j--;
        }
        if (carry == '1') s.push_back('1');
        reverse(s.begin(), s.end());
        return s;
    }
};