// Optimal - Approach (Moore's Voting Algorithm) =>
// Note:- For a qn where the majority element is not guaranteed, a second pass for verification 
// of whether the element left in the 'element' variable is a majority element or not has to be done.
// In that case, T.C = O(2n) = O(n) & S.C = O(1)
// Second Pass -> 

// int cntnew = 0;
// for (int i = 0; i < nums.size(); i++) {
//     if (nums[i] == element) {
//         cntnew++;
//     }
// }
// if (cntnew > nums.size() / 2) return element;
// return -1;

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
