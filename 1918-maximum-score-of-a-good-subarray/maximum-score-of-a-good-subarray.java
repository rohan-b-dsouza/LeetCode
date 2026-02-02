class Solution {
    public int maximumScore(int[] nums, int k) {
        // code here
        int n = nums.length;
        long ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]) {
                int idx = stack.pop();
                int nse = i;
                int pse = stack.isEmpty() ? -1 : stack.peek();
                int l = pse + 1;
                int r = nse - 1;
                if (l <= k && r >= k)
                    ans = Math.max(ans, nums[idx] * 1L * (r - l + 1));
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int idx = stack.pop();
            int nse = n;
            int pse = stack.isEmpty() ? -1 : stack.peek();
            int l = pse + 1;
            int r = nse - 1;
            if (l <= k && r >= k)
                    ans = Math.max(ans, nums[idx] * 1L * (r - l + 1));
        }
        return (int) ans;
    } 
}