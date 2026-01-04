class Solution {
public:
    vector<vector<string>> wordSquares(vector<string>& words) {
        int n = words.size();
        vector<vector<string>> ans;
        for (int i = 0; i < n; i++) {
            string top = words[i];
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                string left = words[j];
                if (left[0] != top[0]) continue;
                for (int k = 0; k < n; k++) {
                    if (j == k || i == k) continue;
                    string right = words[k];
                    if (right[0] != top[3]) continue;
                    for (int l = 0; l < n; l++) {
                        if (i == l || j == l || k == l) continue;
                        string bottom = words[l];
                        if (bottom[0] != left[3] || bottom[3] != right[3]) continue;
                        vector<string> temp = {top, left, right, bottom};
                        ans.push_back(temp);
                    } 
                } 
            }
        }
        sort(ans.begin(), ans.end(), [](const vector <string>& a, const vector <string> &b) {
            for (int i = 0; i < 4; i++) {
                if (a[i] != b[i]) return a[i] < b[i];
            }
            return false;
        });
        return ans;
    }
};

// 18: 43