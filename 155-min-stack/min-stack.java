class MinStack {
    Deque<Long> stack;
    long min;
    public MinStack() {
        stack = new ArrayDeque<>();
        min = Long.MAX_VALUE;
    }

    public void push(int val) {
        long v = val;
        if (stack.isEmpty()) {
            stack.push(v);
            min = v;
        }
        else {
            if (v < min) {
                stack.push(2 * v - min);
                min = v;
            }
            else stack.push(v);
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;
        if (stack.peek() < min) {
            min = 2L * min - stack.pop();
        }
        else {
            stack.pop();
        }
    }

    public int top() {
        if (stack.isEmpty()) return -1;
        if (stack.peek() < min) {
            return (int) min;
        }
        else return (int) (long) stack.peek();
    }

    public int getMin() {
        return (int) min;
    }
}