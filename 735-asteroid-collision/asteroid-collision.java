class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            boolean destroyed = false;
            while (!stack.isEmpty() && asteroids[i] < 0 && stack.peek() > 0) {
                if (-asteroids[i] > stack.peek()) {
                    stack.pop();
                } 
                else if (-asteroids[i] < stack.peek()) {
                    destroyed = true;
                    break;
                }
                else {
                    stack.pop();
                    destroyed = true;
                    break;
                }
            }   
            if (!destroyed) stack.push(asteroids[i]);

        } 
        int[] ans = new int[stack.size()];
        int i = 0;
        Iterator<Integer> it = stack.descendingIterator();
        while (it.hasNext()) {
            ans[i++] = it.next();
        }
        return ans;

    }
}