class Solution {
    // Function that returns the maxarea possible in the histogram
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

    // Function that computes the maximum rectangle area
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        // Array which tracks the histogram at each step
        int[] heights = new int[m];
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            // For each row, create the histogram 
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '0')
                    heights[j] = 0;
                else
                    heights[j] += 1;
            }
            // Pass this histogram to largestRectangleArea() to get the maximum possible area and update maxArea
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        // Return maxArea
        return maxArea;
    }
}

// T.C => O(n * m) + O(n * (2 * m)) = O(3 * (n * m)) = O(n * m)
// S.C => O(m) + O(m) = O(2 * m) = o(m)
