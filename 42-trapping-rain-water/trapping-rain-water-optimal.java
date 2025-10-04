// Optimal (Two - Pointers)

class Solution {
  public int trap(int[] height) {
    int n = height.length;
    // Initialize leftMax and rightMax and water to 0
    int leftMax = 0;
    int rightMax = 0;
    int water = 0;
    // Set left and right pointers
    int left = 0;
    int right = n - 1;
    // Iterate till left is smaller than right
    while (left < right) {
      // If left wall is smaller than or equal to right wall
      if (height[left] <= height[right]) {
        // And if left max wall is greater than current left wall, add trapped water
        if (leftMax > height[left]) {
          water += leftMax - height[left];
          // Else, update leftMax
        } else {
          leftMax = Math.max(leftMax, height[left]);
        }
        // Increment left pointer
        left++;
        
      } 
      // Else, if right wall is smaller than left wall
      else {
        // If right max wall is greater than current right wall, add trapped water
        if (rightMax > height[right]) {
          water += rightMax - height[right];  
        } 
        // Else, update rightMax
        else {
          rightMax = Math.max(rightMax, height[right]);
        }
        // Decrement right pointer
        right--;
      }
    }
    // Return the water
    return water;
  }
}

// T.C => O(n)
// S.C => O(1)
