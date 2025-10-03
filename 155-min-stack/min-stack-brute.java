// Brute

class MinStack {
// Stack of int[] to store pairs of {Element, Minimum element seen so far}
Deque<int[]> stack;
    // Initialize the stack
    public MinStack() {
          stack = new ArrayDeque<>();
    }
    public void push(int val) {
        // If stack is empty, store the pair as {element, element} as only one element seen so far
        if (stack.isEmpty()) stack.push(new int[] {val, val});
        // Else 
        else {
            // Store the current element with the minimum element seen so far
            stack.push(new int[] {val, Math.min(val, stack.peek()[1])});
        }
    }
    // Pop the stack's top
    public void pop() {
        stack.pop();
    }
    // Return the top element
    public int top() {
        return stack.peek()[0];
    }
    // Return the current minimum element
    public int getMin() {
        return stack.peek()[1];
    }
}

// T.C => O(1)
// S.C => O(2 * n) for the stack of int[] => O(n)
