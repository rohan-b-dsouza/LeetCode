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

    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] heights = new int[m];
        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '0')
                    heights[j] = 0;
                else
                    heights[j] += 1;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }
}
