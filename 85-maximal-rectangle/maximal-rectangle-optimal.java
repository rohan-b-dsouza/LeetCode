// Optimal (Refer problem Largest Rectangle in Histogram to solve this problem as this is just an extension of that problem)

class Solution {
    // Function that returns the maxarea possible in the histogram
    public int largestRectangleArea(int[] heights) {
       int n = heights.length;
       Deque<Integer> stack = new ArrayDeque<>();
       int maxArea = 0;
    
        for (int i = 0; i < n; i++) {
        // If stack is not empty and current element is smaller than stack's top   
        while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
            // Current element is the next smaller element of stack's top
            int nse = i;
            // Get the height of element at stack's top and also pop it
            int currHeight = heights[stack.pop()];
            // Since we are maintaining a monotonic increasing stack, the pse of this popped element will be the new stack top
            // However, if stack is empty it means there is no PSE for this element therefore take -1
            int pse = stack.isEmpty() ? -1 : stack.peek();
            // Compute the area and update maxArea
            maxArea = Math.max(maxArea, (currHeight * ((nse - pse) - 1)));
        }
            // Push the current element to the stack
        stack.push(i);
       }
        // If stack still has elements these are the elements which don't have a NSE, hence set NSE as n
        // Now, compute the area based on nse and pse (if does'nt exist set PSE as -1 and update maxArea)
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
