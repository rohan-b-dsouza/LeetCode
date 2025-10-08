// Optimal (Refer GFG version of this problem to understand better as the leetcode one is poorly described and also unnecessary twist of design has been made which makes it confusing)
// (Monotonic Decreasing Stack)

class StockSpanner {
    private Deque<int[]> stack; // pair = {price, span}
    // Initialize the stack
    public StockSpanner() {
        stack = new ArrayDeque<>();
    }
    public int next(int price) {
         // Initialize span to 1
        int span = 1;
        // If stack is not empty, and current stock price is greater than peek stock price, add peek's span to span
        while (!stack.isEmpty() && price >= stack.peek()[0]) {
            span += stack.pop()[1];
        }
        // Push the current price to the stack
        stack.push(new int[]{price, span});
        // Return span
        return span;
    }
}


/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */

// T.C => O(n) in worst-case, but O(1) amortized per call
// S.C => O(n)
