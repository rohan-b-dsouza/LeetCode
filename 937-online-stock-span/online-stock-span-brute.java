// Brute


class StockSpanner {
    private Deque<int[]> stack; // pair = {price, span}
    // Initialize the stack
    public StockSpanner() {
        stack = new ArrayDeque<>();
    }
    public int next(int price) {
         // Initialize span to 1
        int span = 1;
        
        // Push the current price to the stack
        stack.push(new int[]{price, span});
        // Return span
        return span;
    }
}


int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int span = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (arr[j] > arr[i]) break;
                span++;
            }
            ans[i] = span;
        }
        return ans;
