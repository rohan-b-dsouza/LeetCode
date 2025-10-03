// Optimal

class MinStack {
    // Declare a 'Long' stack and 'long' min for handling Integer overflow issues during multiplication
    Deque<Long> stack;
    long min;
    // Initialize the stack and min
    public MinStack() {
        stack = new ArrayDeque<>();
        min = Long.MAX_VALUE;
    }
    public void push(int val) {
        // Store val in long
        long v = val;
        // If stack is empty, push v and set min to v
        if (stack.isEmpty()) {
            stack.push(v);
            min = v;
        }
        // Else  
        else {
            // If v is smaller than min, push encoded value into the stack and set min to v
            if (v < min) {
                stack.push(2 * v - min);
                min = v;
            }
            // Else, push v to the stack
            else stack.push(v);
        }
    }
    
    public void pop() {
        // If stack is empty, return
        if (stack.isEmpty()) return;
        // If stack's top is smaller than min, pop the stack's top and go back to previous min using the encoded value
        if (stack.peek() < min) {
            min = 2L * min - stack.pop();
        }
        // Else, pop the stack's top
        else {
            stack.pop();
        }
    }

    public int top() {
        // If stack is empty, return -1
        if (stack.isEmpty()) return -1;
        // If stack's top is smaller than min, return min
        if (stack.peek() < min) {
            return (int) min;
        }
        // Else, return stack's top
        else return (int) (long) stack.peek();
    }
    // Return min
    public int getMin() {
        return (int) min;
    }
}

// T.C => O(1)
// S.C => O(n)
