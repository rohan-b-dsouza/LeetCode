// better approach
class Solution {
public:
    int trap(vector<int>& height) {
        int water = 0;
        int leftMax = INT_MIN, rightMax = INT_MIN;
        vector <int> prefixMax(height.size());
        for (int j = 0; j < height.size(); j++) {
                if (height[j] > leftMax) leftMax = height[j];
                prefixMax[j] = leftMax;
            }
        vector <int> suffixMax(height.size());
        for (int j = height.size() - 1; j >= 0; j--) {
                if (height[j] > rightMax) rightMax = height[j];
                suffixMax[j] = rightMax;
            }
        for (int i = 0; i < height.size() - 1; i++) {
            water += min(prefixMax[i], suffixMax[i]) - height[i];
        }
        return water;
    }
};
// T.C = O(n) + O(n) + O(n) = O(3n) = O(n)
// S.C = O(2n) as 2 extra arrays are used (for prefixMax and suffixMax)