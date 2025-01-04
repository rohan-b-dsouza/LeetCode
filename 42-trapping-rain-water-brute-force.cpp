// brute force approach
class Solution {
public:
    int trap(vector<int>& height) {
        int water = 0;
        for (int i = 0; i < height.size(); i++) { // traverse through each building(bar)(index)
            int leftMax = INT_MIN, rightMax = INT_MIN;
            for (int j = 0; j <= i; j++) { // calculate prefixMax for that index (building)
                if (height[j] > leftMax) leftMax = height[j];
            }
            for (int j = i; j < height.size(); j++) { // calculate suffixMax for that index (building)
                if (height[j] > rightMax) rightMax = height[j];
            }
            water += min(leftMax, rightMax) - height[i]; // calculate water trapped at that index (building)
        }
        return water;
    }
};
// T.C = O(n^2)
// S.C = O(1)
