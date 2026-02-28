class Solution {
public:
    string addBinary(string a, string b) {
        int n = a.size();
        int m = b.size();
        int i = a.size() - 1; int j = b.size() - 1;
        int carry = 0;
        string ans(max(n, m) + 1, '0');
        int k = ans.size() - 1;
        while (i >= 0 || j >= 0 || carry) {
            int sum = carry;
            if (i >= 0) sum += a[i--] - '0';
            if (j >= 0) sum += b[j--] - '0';
            ans[k--] = sum % 2 + '0';
            carry = sum / 2;
        }
        if (ans[0] == '0') {
            return ans.substr(1);
        }
        return ans;
    }
};