// optimal solution - approach
class Solution { 
public:
    int trap(vector<int>& height) {
        int water = 0;
        int leftMax = 0, rightMax = 0;
        int left = 0, right = height.size() - 1;
        while (left <= right) { // when left > right break loop as water is trapped successfully whereever possible
            if (height[left] <= height[right]) { // checks if there exists a right bar taller than this left bar
                leftMax = max(leftMax, height[left]); 
                water += leftMax - height[left]; 
                left++;
            }
            else { // if height[right] < height[left] (checks if there exists a left bar taller than this right bar)
                rightMax = max(rightMax, height[right]);
                water += rightMax - height[right];
                right--;
            }
        }
        return water;

    }
};
// T.C = O(n)
// T.C = O(1)