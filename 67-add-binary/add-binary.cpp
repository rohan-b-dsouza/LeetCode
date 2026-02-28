class Solution {
public:
    string addBinary(string a, string b) {

        int n = a.size(), m = b.size();
        string ans(max(n, m) + 1, '0');

        int i = n - 1, j = m - 1, k = ans.size() - 1;
        int carry = 0;

        while (i >= 0 || j >= 0 || carry) {

            int sum = carry;

            if (i >= 0) sum += a[i--] - '0';
            if (j >= 0) sum += b[j--] - '0';

            ans[k--] = (sum % 2) + '0';
            carry = sum / 2;
        }

        if (ans[0] == '0')
            return ans.substr(1);

        return ans;
    }
};