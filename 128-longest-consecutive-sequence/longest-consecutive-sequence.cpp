// Optimal - Approach => 
// (Using unordered set and its find function which takes O(1) T.C)

class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        if (nums.empty()) return 0;
        unordered_set <int> st;
        int longest = 1;
        for (int i = 0; i < nums.size(); i++) {
            st.insert(nums[i]);
        }
        for (auto it : st) {
            if (st.find(it - 1) == st.end()) {
                int cnt = 1;
                int x = it + 1;
                while (st.find(x) != st.end()) {
                    cnt++;
                    x++;
                }
                longest = max(longest, cnt);
            }
        }
        return longest;
    }
};

// T.C => O(n) + O(2n) = O(3n) = O(n) ...{For the best and average case}
// Note:- However, if the worst case can occur due to collisions then its better to use the 'Better' solution as using 
// ordered set will also be inefficient}

// S.C => O(n)
