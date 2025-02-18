// Optimal - Approach (Moore's Voting Algorithm) =>
// Note:- For a qn where the majority element is not guaranteed, a second pass for verification 
// of whether the element left in the 'element' is a majority element or not has to be done, for that refer Code 360 - 
// Majority Element

class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int cnt = 0;
        int element = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (cnt == 0) {
                cnt = 1;
                element = nums[i];
            }
            else if (nums[i] == element) {
                cnt++;
            }
            else cnt--;
        }
        return element;
    }
};

// T.C => O(n)
// S.C => O(1)