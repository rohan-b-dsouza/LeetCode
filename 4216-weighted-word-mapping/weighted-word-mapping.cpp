class Solution {
public:
    string mapWordWeights(vector<string>& words, vector<int>& weights) {
        int n = words.size();
        unordered_map<int, char> hash;
        string ans = "";
        for (int i = 0; i < n; i++) {
            string word = words[i];
            int cost = 0;
            for (int j = 0; j < word.size(); j++) {
                cost += weights[word[j] - 'a'];
            }
            cost %= 26;
            char mappedChar = (char) ('z' - cost);
            ans += mappedChar;
        }
        return ans;
    }
};