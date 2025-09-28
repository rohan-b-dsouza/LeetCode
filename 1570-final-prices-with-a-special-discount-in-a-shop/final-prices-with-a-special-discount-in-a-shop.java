class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            // If stack is not empty and stack's peek is greater than or equal to current element, then pop the stack's top
            while (!stack.isEmpty() && stack.peek() > prices[i]) {
                stack.pop();
            }
            // If stack is empty, then -1 is the NSE of the current element
            if (stack.isEmpty()) ans[i] = prices[i];
            // Else NSE of the current element is stack's top
            else ans[i] = prices[i] - stack.peek();
            // Push current element to the stack
            stack.push(prices[i]);
        }
        // Return the list
        return ans;

    }
}