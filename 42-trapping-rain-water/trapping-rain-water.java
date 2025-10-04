class Solution {
  public int trap(int[] height) {
    int n = height.length;
    int leftMax = 0;
    int rightMax = 0;
    int water = 0;
    int left = 0;
    int right = n - 1;
    while (left < right) {
      if (height[left] <= height[right]) {
        if (leftMax > height[left]) {
          water += leftMax - height[left];
        } else {
          leftMax = Math.max(leftMax, height[left]);
        }
        left++;
      } else {
        if (rightMax > height[right]) {
          water += rightMax - height[right];
        } else {
          rightMax = Math.max(rightMax, height[right]);
        }
        right--;
      }
      
    }
    return water;
  }
}
