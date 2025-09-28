// Optimal (Similar to the problem 'Next Smaller Element') (Monotonic Increasing Stack)

class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] ans = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
         // If stack is not empty and stack's top element price is greater than current element then pop it from the stack
            while (!stack.isEmpty() && stack.peek() > prices[i]) {
                stack.pop();
            }
             // If stack is empty then no discount is possible hence put current element price as it is to the ans
            if (stack.isEmpty()) ans[i] = prices[i];
            // Else give discount on current price using stack's top and put this discounted price to the ans
            else ans[i] = prices[i] - stack.peek();
            // Push current price to the stack
            stack.push(prices[i]);
        }
        // Return the ans
        return ans;
    }
}

// T.C => O(2 * n) = O(n)
// S.C => O(2 * n) = O(n)
