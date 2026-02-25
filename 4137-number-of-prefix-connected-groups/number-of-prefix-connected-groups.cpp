class Solution {
public:
    int prefixConnected(vector<string>& words, int k) {
        int ans = 0;
        unordered_map<string, int> mp;
        for (string str : words) {
            if (str.size() < k) continue;
            mp[str.substr(0, k)]++;
        }
        for (auto &[key, value] : mp) {
            if (value >= 2) ans++;
        } 
        return ans;
    }
};