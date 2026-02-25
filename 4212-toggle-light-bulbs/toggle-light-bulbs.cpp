class Solution {
public:
    vector<int> toggleLightBulbs(vector<int>& bulbs) {
        vector<int> ans;
        map<int, bool> mp;
        for (auto &it : bulbs) { 
            if (!mp[it]) mp[it] = true;
            else mp[it] = false;
        }
        for (auto &it : mp) {
            if (it.second) {
                ans.push_back(it.first);
            }
        }
        return ans;
    }
};