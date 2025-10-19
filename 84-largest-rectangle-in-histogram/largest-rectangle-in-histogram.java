class Solution {
    public int largestRectangleArea(int[] heights) {
       int n = heights.length;
       Deque<Integer> stack = new ArrayDeque<>();
       int maxArea = 0;
       for (int i = 0; i < n; i++) {
        while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
            int nse = i;
            int currHeight = heights[stack.pop()];
            int pse = stack.isEmpty() ? -1 : stack.peek();
            maxArea = Math.max(maxArea, (currHeight * ((nse - pse) - 1)));
        }
        stack.push(i);
       }
       while (!stack.isEmpty()) {
        int nse = n;
        int currHeight = heights[stack.pop()];
        int pse = stack.isEmpty() ? -1 : stack.peek();
        maxArea = Math.max(maxArea, currHeight * ((nse - pse) - 1));
       }
       return maxArea;
    }
}
