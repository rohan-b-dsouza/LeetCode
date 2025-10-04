// Brute

class Solution {
    public int trap(int[] height) {
       int n = height.length;
        // Variable to track the max height on left so far
       int leftMax = height[0];
        // Array that stores the maximum height on right till an index i
       int[] rightMax = new int[n];
        // Initialize water to 0
       int water = 0;
       rightMax[n - 1] = height[n - 1];
        // Fill the 'rightMax' array
       for (int i = n - 2; i >= 0; i--) {
        rightMax[i] = Math.max(rightMax[i + 1], height[i]);
       }
       for (int i = 0; i < n; i++) {
            // Update leftMax
           leftMax = Math.max(leftMax, height[i]);
           // If current wall height is smaller than left max wall and right max wall, then water is (minimum of left max wall and right max wall) - (current wall height)
            if (height[i] < leftMax && height[i] < rightMax[i]) {
                water += (Math.min(leftMax, rightMax[i]) - height[i]);
            }
       }
        // Return water
       return water;
    }
}

// T.C => O(2 * n) = O(n)
// S.C => O(n)
