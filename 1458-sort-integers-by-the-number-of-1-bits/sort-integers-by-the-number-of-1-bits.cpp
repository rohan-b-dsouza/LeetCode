class Solution {
public:
    vector<int> sortByBits(vector<int>& arr) {
        int n = arr.size();
        sort(arr.begin(), arr.end(), [](auto a, auto b) {
            int ca = __builtin_popcount(a);
            int cb = __builtin_popcount(b);
            if (ca != cb) {
                return ca < cb;
            }
            return a < b;
        });
        return arr;
    }
};