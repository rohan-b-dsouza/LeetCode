// Follow - up question :- Print subarray with maximum subarray sum (extended version of Leetcode 53. Maximum Subarray Sum) =>

#include <iostream>
#include <vector>
#include <limits.h>
using namespace std;

class Solution {
    public:
        void maxSubArray(vector<int>& nums) {
            int sum = 0;
            int largestSumSubarray= INT_MIN;
            int start = 0;
            int end = 0;
            int startIdx = 0;
            for (int i = 0; i < nums.size(); i++) {
                sum += nums[i];
                if (sum > largestSumSubarray) {
                  largestSumSubarray = sum;
                  startIdx = start;
                  end = i;
                }
                if (sum < 0) {
                    sum = 0;
                    start = i + 1;
                }  
            }
            cout << largestSumSubarray;
            cout << endl << startIdx << " " << end; 

        }
};

int main() {
    int n;
    cout << "Enter value of n : ";
    cin >> n;
    vector <int> arr;
    cout << "Enter the elements : ";
    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;
        arr.push_back(x);
    }
    Solution s1;
    s1.maxSubArray(arr);

}

// T.C => O(n)
// S.C => O(1)
