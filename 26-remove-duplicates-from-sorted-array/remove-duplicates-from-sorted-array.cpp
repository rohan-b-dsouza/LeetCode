// Brute - Force Approach =>

class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        set <int> st;
        for (int i = 0; i < nums.size(); i++) {
            st.insert(nums[i]);
        }
        int index = 0;
        for (auto it : st) {
            nums[index] = it;
            index++;
        }
        return index;
    }
};

// T.C => O(nlog(n)) + O(n) = O(n)
// S.C => O(n) for the extra set used
