// Better - Approach 1 =>
// Using hashing =>

class Solution {
public:
    int missingNumber(vector<int>& nums) {
       int n = nums.size();
       vector <int> hash(n + 1, 0);
       for (int i = 0; i < nums.size(); i++) {
        hash[nums[i]]++;
       }
       for (int i = 0; i < hash.size(); i++) {
        if (hash[i] == 0) return i;
       }
       return -1;
    }
};

// T.C => O(n) + O(n) = O(2n) = O(n)
// S.C => O(1)
