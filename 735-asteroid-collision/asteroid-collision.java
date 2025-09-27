// Optimal

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            // Mark flag destroyed as false initially
            boolean destroyed = false;
            // If stack is not empty, and current element is a left moving asteroid and stack's top is right moving 
            while (!stack.isEmpty() && asteroids[i] < 0 && stack.peek() > 0) {
                // If left moving is larger then pop right moving
                if (-asteroids[i] > stack.peek()) {
                    stack.pop();
                } 
                    // If left moving is smaller, then mark destroyed as true and break as it can't collide further
                else if (-asteroids[i] < stack.peek()) {
                    destroyed = true;
                    break;
                }
                    // If both asteroids are of same size, then destroy both and mark destroyed true as further collisions of current left moving asteroid is not possible
                else {
                    stack.pop();
                    destroyed = true;
                    break;
                }
            }   
            // If current left moving asteroid was'nt destroyed push it on the stack
            if (!destroyed) stack.push(asteroids[i]);

        } 
        int[] ans = new int[stack.size()];
        int i = 0;
        // Since, elements in stack are stored top to bottom order (eg. [12, 5]) top = 12, bottom = 5, hence we need an iterator that iterates from bottom to top as answer is reqd in that order
        Iterator<Integer> it = stack.descendingIterator();
        // While next element is available, keep iterating
        while (it.hasNext()) {
            // Add the element to the ans
            ans[i++] = it.next();
        }
        // Return the ans;
        return ans;
    }
}

// NOTE :- A collision is considered only when a left moving asteroid is on the right of the right moving asteroid in the array. For eg. if the stack has a negative element -4.
// Then a right moving asteroid 1 can't collide with it as it is on right of left moving asteroid in the array. Hence, in this case actually both these asteroids are moving away from each other.

// T.C => O(2 * n) = O(n)
// S.C => O(2 * n) for the stack and 'ans' array = O(n)
