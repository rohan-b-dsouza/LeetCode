class Solution {
    public int maximumScore(int[] nums, int k) {
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            while(!stack.isEmpty() && nums[stack.peek()] > nums[i]) {
                int idx = stack.pop();
                int nse = i;
                int pse = stack.isEmpty() ? -1 : stack.peek();
                int left = pse + 1; int right = nse - 1;
                if (left > k || right < k) continue;
                ans = Math.max(nums[idx] * 1L * (right - left + 1), ans); 
            }
            stack.push(i);
        }
        while(!stack.isEmpty()) {
            int idx = stack.pop();
            int nse = n;
            int pse = stack.isEmpty() ? -1 : stack.peek();
            int left = pse + 1; int right = nse - 1;
            if (left > k || right < k) continue;
            ans = Math.max(nums[idx] * 1L * (right - left + 1), ans); 
        } 
        return (int) ans;
    }
}